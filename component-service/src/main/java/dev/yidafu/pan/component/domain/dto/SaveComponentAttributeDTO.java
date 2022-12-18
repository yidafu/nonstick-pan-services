package dev.yidafu.pan.component.domain.dto;

import lombok.Data;

import javax.annotation.Generated;

@Data
public class SaveComponentAttributeDTO {

    private Long ownerId;

    private String attr;

    private Byte valueType;

    private String value;
}
