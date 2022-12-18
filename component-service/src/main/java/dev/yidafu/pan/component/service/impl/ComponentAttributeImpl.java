package dev.yidafu.pan.component.service.impl;

import dev.yidafu.pan.component.domain.dao.ComponentAttributeDynamicSqlSupport;
import dev.yidafu.pan.component.domain.dao.ComponentAttributeMapper;
import dev.yidafu.pan.component.domain.entity.ComponentAttribute;
import dev.yidafu.pan.component.service.ComponentAttributeService;
import dev.yidafu.pan.component.service.ComponentService;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ComponentAttributeImpl implements ComponentAttributeService {

    @Autowired
    ComponentAttributeMapper mapper;

    @Override
    public List<ComponentAttribute> findAllByOwner(Long ownerId) {
        SelectDSLCompleter completer = c -> c.where().and(ComponentAttributeDynamicSqlSupport.owerId, SqlBuilder.isEqualTo(ownerId));
        mapper.select(completer);
        return null;
    }

    @Override
    public ComponentService updateByAttr(String attr, String value) {
        return null;
    }

    @Override
    public ComponentService updateByAttr(Long id, String value) {
        return null;
    }

    @Override
    public List<ComponentAttribute> batchUpdateAttr(Map<String, String> map) {
        return null;
    }

    @Override
    public Boolean remoteByAttr(String attr) {
        return null;
    }

    @Override
    public Boolean remoteById(Long id) {
        return null;
    }
}
