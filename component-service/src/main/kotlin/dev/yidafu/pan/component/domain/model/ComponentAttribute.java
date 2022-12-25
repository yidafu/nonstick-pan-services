package dev.yidafu.pan.component.domain.model;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;

public class ComponentAttribute implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long ownerId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String attr;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte valueType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String value;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createdAt;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updatedAt;

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
    public Long getOwnerId() {
        return ownerId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAttr() {
        return attr;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAttr(String attr) {
        this.attr = attr == null ? null : attr.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getValueType() {
        return valueType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setValueType(Byte valueType) {
        this.valueType = valueType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getValue() {
        return value;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
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
}