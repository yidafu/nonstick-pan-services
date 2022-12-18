package dev.yidafu.pan.component.service;

import dev.yidafu.pan.component.domain.dto.SaveComponentAttributeDTO;
import dev.yidafu.pan.component.domain.dto.UpdateComponentAttributeDTO;
import dev.yidafu.pan.component.domain.entity.ComponentAttribute;

import java.util.List;
import java.util.Map;

public interface ComponentAttributeService {
    ComponentAttribute findOneById(Long id);

    ComponentAttribute findOneByAttr(String attr);

    List<ComponentAttribute> findAllByOwner(Long ownerId);

    ComponentAttribute createOne(SaveComponentAttributeDTO dto);

    List<ComponentAttribute> batchCreate(List<SaveComponentAttributeDTO> list);

    ComponentAttribute updateByAttr(String attr, String value);

    ComponentAttribute updateById(Long id, String value);

    List<ComponentAttribute> batchUpdateAttr(List<UpdateComponentAttributeDTO> list);

    Boolean remoteByAttr(Long ownerId, String attr);


    Boolean remoteByAttrs(Long ownerId, List<String> attrList);

    Boolean remoteById(Long id);
}
