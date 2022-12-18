package dev.yidafu.pan.component.domain.bo;

import lombok.Data;

import java.util.Map;

@Data
public class ComponentAttributeBO {
    Integer valueType;

    Map<String, String> valueStore;
}
