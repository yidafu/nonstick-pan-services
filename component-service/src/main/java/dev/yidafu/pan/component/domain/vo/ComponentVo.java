package dev.yidafu.pan.component.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ComponentVo {
    private Long id;

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

    private Date createdAt;

    private Date updatedAt;

    private String styleLabelConfig;

    private String styleConfig;

    private String requestConfig;

    private String interactConfig;

}
