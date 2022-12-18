package dev.yidafu.pan.component.domain.dto;


import lombok.Data;

@Data
public class BaseCompnentDto {
    private Long screenId;

    private Long groupId;

    private String name;

    private String layerName;

    private Byte isGroup;

    private Integer width;

    private Integer height;

    private Integer offsetX;

    private Integer offsetY;

    private Integer zIndex;

    private Byte isLock;

    private Byte isLockAspectRatio;

    private String category;

    private String subCategory;

    private String umdJsUrl;

    private String styleLabelConfig;

    private String styleConfig;

    private String requestConfig;

    private String interactConfig;
}
