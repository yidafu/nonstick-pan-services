package dev.yidafu.pan.component.service.impl;

import dev.yidafu.pan.component.common.exception.IllegalComponentAttributeOwnerException;
import dev.yidafu.pan.component.common.json.JsonValue;
import dev.yidafu.pan.component.convertor.ComponentAttributeConvertor;
import dev.yidafu.pan.component.domain.dao.ComponentAttributeDynamicSqlSupport;

import dev.yidafu.pan.component.domain.dao.ComponentAttributeMapper;
import dev.yidafu.pan.component.domain.dto.SaveComponentAttributeDTO;
import dev.yidafu.pan.component.domain.dto.SaveComponentDTO;
import dev.yidafu.pan.component.domain.dto.UpdateComponentAttributeDTO;
import dev.yidafu.pan.component.domain.entity.ComponentAttribute;
import dev.yidafu.pan.component.service.ComponentAttributeService;
import dev.yidafu.pan.component.service.ComponentService;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils.insertMultiple;

import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ComponentAttributeImpl implements ComponentAttributeService {

    @Autowired
    ComponentAttributeMapper mapper;

    @Autowired
    ComponentAttributeConvertor convertor;

    public ComponentAttribute findOneById(Long id) {
        SelectDSLCompleter completer = c -> c
                .where()
                .and(ComponentAttributeDynamicSqlSupport.id, isEqualTo(id));
        return mapper.selectOne(completer).orElse(null);
    }

    public ComponentAttribute findOneByAttr(String attr) {
        SelectDSLCompleter completer = c -> c
                .where()
                .and(ComponentAttributeDynamicSqlSupport.attr, isEqualTo(attr));
        return mapper.selectOne(completer).orElse(null);
    }
    @Override
    public List<ComponentAttribute> findAllByOwner(Long ownerId) {
        SelectDSLCompleter completer = c -> c
                .where()
                .and(ComponentAttributeDynamicSqlSupport.ownerId, isEqualTo(ownerId));

        List<ComponentAttribute> componentAttributes = mapper.select(completer);
        return componentAttributes;
    }

    @Override
    public ComponentAttribute createOne(SaveComponentAttributeDTO dto) {
        ComponentAttribute componentAttribute = convertor.from(dto);
        mapper.insert(componentAttribute);
        return findOneById(componentAttribute.getId());
    }

    @Override
    public List<ComponentAttribute> batchCreate(List<SaveComponentAttributeDTO> list) {
        Long ownerId = list.get(0).getOwnerId();

        boolean isTheSomeOwner = list.stream().allMatch(attr -> Objects.equals(attr.getOwnerId(), ownerId));
        if (!isTheSomeOwner) {
            throw new IllegalComponentAttributeOwnerException();
        }

        List<ComponentAttribute> attributeList = convertor.from(list);
        mapper.insertMultiple(attributeList);
        return findAllByOwner(ownerId);
    }

    @Override
    public ComponentAttribute updateByAttr(String attr, String value) {
        UpdateDSLCompleter completer = c -> c
                .set(ComponentAttributeDynamicSqlSupport.value).equalTo(value)
                .where()
                .and(ComponentAttributeDynamicSqlSupport.attr, isEqualTo(attr));
        mapper.update(completer);
        return findOneByAttr(attr);
    }

    @Override
    public ComponentAttribute updateById(Long id, String value) {
        UpdateDSLCompleter completer = c -> c
                .set(ComponentAttributeDynamicSqlSupport.value).equalTo(value)
                .where()
                .and(ComponentAttributeDynamicSqlSupport.id, isEqualTo(id));
        mapper.update(completer);
        return findOneById(id);
    }

    @Override
    public List<ComponentAttribute> batchUpdateAttr(List<UpdateComponentAttributeDTO> list) {
        return list.stream().map(dto -> {
            updateByAttr(dto.getAttr(), dto.getValue());
            return findOneByAttr(dto.getAttr());
        }).collect(Collectors.toList());
    }

    @Override
    public Boolean remoteByAttr(Long ownerId, String attr) {
        return remoteByAttrs(ownerId, Collections.singletonList(attr));
    }

    @Override
    public Boolean remoteByAttrs(Long ownerId, List<String> attrList) {
        DeleteDSLCompleter completer = c -> c
                .where()
                .and(ComponentAttributeDynamicSqlSupport.ownerId, isEqualTo(ownerId))
                .and(ComponentAttributeDynamicSqlSupport.attr, SqlBuilder.isIn(attrList));
        return mapper.delete(completer) > 0;
    }

    @Override
    public Boolean remoteById(Long id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }
}
