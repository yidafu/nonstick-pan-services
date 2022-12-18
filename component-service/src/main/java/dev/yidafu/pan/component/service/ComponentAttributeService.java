package dev.yidafu.pan.component.service;

import dev.yidafu.pan.component.domain.entity.ComponentAttribute;

import java.util.List;
import java.util.Map;

public interface ComponentAttributeService {
    List<ComponentAttribute> findAllByOwner(Long ownerId);

    ComponentService updateByAttr(String attr, String value);

    ComponentService updateByAttr(Long id, String value);

    List<ComponentAttribute> batchUpdateAttr(Map<String, String> map);

    Boolean remoteByAttr(String attr);

    Boolean remoteById(Long id);
}
