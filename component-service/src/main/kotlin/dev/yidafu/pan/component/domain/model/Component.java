package dev.yidafu.pan.component.domain.model;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;

public class Component implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long screenId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long groupId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String layerName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte isGroup;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer width;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer height;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer offsetX;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer offsetY;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer zIndex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte isLock;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte isLockAspectRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String category;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String subCategory;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String umdJsUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createdAt;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updatedAt;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String styleLabelConfig;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String styleConfig;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String requestConfig;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String interactConfig;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getScreenId() {
        return screenId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getGroupId() {
        return groupId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getLayerName() {
        return layerName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLayerName(String layerName) {
        this.layerName = layerName == null ? null : layerName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getIsGroup() {
        return isGroup;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIsGroup(Byte isGroup) {
        this.isGroup = isGroup;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getWidth() {
        return width;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHeight() {
        return height;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getOffsetX() {
        return offsetX;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOffsetX(Integer offsetX) {
        this.offsetX = offsetX;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getOffsetY() {
        return offsetY;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOffsetY(Integer offsetY) {
        this.offsetY = offsetY;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getzIndex() {
        return zIndex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setzIndex(Integer zIndex) {
        this.zIndex = zIndex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getIsLock() {
        return isLock;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIsLock(Byte isLock) {
        this.isLock = isLock;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getIsLockAspectRatio() {
        return isLockAspectRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIsLockAspectRatio(Byte isLockAspectRatio) {
        this.isLockAspectRatio = isLockAspectRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCategory() {
        return category;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getSubCategory() {
        return subCategory;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory == null ? null : subCategory.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUmdJsUrl() {
        return umdJsUrl;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUmdJsUrl(String umdJsUrl) {
        this.umdJsUrl = umdJsUrl == null ? null : umdJsUrl.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreatedAt() {
        return createdAt;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getStyleLabelConfig() {
        return styleLabelConfig;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStyleLabelConfig(String styleLabelConfig) {
        this.styleLabelConfig = styleLabelConfig == null ? null : styleLabelConfig.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getStyleConfig() {
        return styleConfig;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStyleConfig(String styleConfig) {
        this.styleConfig = styleConfig == null ? null : styleConfig.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRequestConfig() {
        return requestConfig;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRequestConfig(String requestConfig) {
        this.requestConfig = requestConfig == null ? null : requestConfig.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getInteractConfig() {
        return interactConfig;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setInteractConfig(String interactConfig) {
        this.interactConfig = interactConfig == null ? null : interactConfig.trim();
    }
}