package dev.yidafu.pan.component.service.impl;

import dev.yidafu.pan.component.convertor.ComponentConvertor;
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport;
import dev.yidafu.pan.component.domain.dao.ComponentMapper;
import dev.yidafu.pan.component.domain.dto.SaveComponentDto;
import dev.yidafu.pan.component.domain.dto.UpdateComponentDto;
import dev.yidafu.pan.component.domain.entity.Component;
import dev.yidafu.pan.component.domain.vo.ComponentVo;
import dev.yidafu.pan.component.service.ComponentService;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

public class ComponentServiceImpl implements ComponentService {
    @Autowired(required = false)
    ComponentMapper componentMapper;

    @Autowired
    ComponentConvertor convertor;

    @Override
    public ComponentVo findById(Long id) {
        SelectDSLCompleter completer = c -> c.where().and(ComponentDynamicSqlSupport.id, isEqualTo(id));
        Optional<Component> optCom = componentMapper.selectOne(completer);
        return optCom.map(component -> convertor.to(component)).orElse(null);
    }

    @Override
    public List<ComponentVo> findAllByScreenId(Long screenId) {
        SelectDSLCompleter completer = c -> c.where().and(ComponentDynamicSqlSupport.screenId, isEqualTo(screenId));
        List<Component> componentList = componentMapper.select(completer);

        return convertor.to(componentList);
    }

    @Override
    public ComponentVo updateById(Long id, UpdateComponentDto dto) {
        Component component = convertor.from(dto);
        component.setId(id);
        componentMapper.updateByPrimaryKey(component);
        return findById(id);
    }

    @Override
    public ComponentVo createOne(SaveComponentDto dto) {
        Component component = convertor.from(dto);

        componentMapper.insert(component);

        return findById(component.getId());
    }
}
