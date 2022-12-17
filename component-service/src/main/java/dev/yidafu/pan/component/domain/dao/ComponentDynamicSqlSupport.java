package dev.yidafu.pan.component.domain.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ComponentDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Component component = new Component();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = component.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> screenId = component.screenId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> groupId = component.groupId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = component.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> layerName = component.layerName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> isGroup = component.isGroup;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> width = component.width;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> height = component.height;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> offsetX = component.offsetX;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> offsetY = component.offsetY;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> zIndex = component.zIndex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> isLock = component.isLock;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> isLockAspectRatio = component.isLockAspectRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> category = component.category;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> subCategory = component.subCategory;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> umdJsUrl = component.umdJsUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createdAt = component.createdAt;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updatedAt = component.updatedAt;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> styleLabelConfig = component.styleLabelConfig;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> styleConfig = component.styleConfig;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> requestConfig = component.requestConfig;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> interactConfig = component.interactConfig;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Component extends AliasableSqlTable<Component> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> screenId = column("screen_id", JDBCType.BIGINT);

        public final SqlColumn<Long> groupId = column("group_id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> layerName = column("layer_name", JDBCType.VARCHAR);

        public final SqlColumn<Byte> isGroup = column("is_group", JDBCType.TINYINT);

        public final SqlColumn<Integer> width = column("width", JDBCType.INTEGER);

        public final SqlColumn<Integer> height = column("height", JDBCType.INTEGER);

        public final SqlColumn<Integer> offsetX = column("offset_x", JDBCType.INTEGER);

        public final SqlColumn<Integer> offsetY = column("offset_y", JDBCType.INTEGER);

        public final SqlColumn<Integer> zIndex = column("z_index", JDBCType.INTEGER);

        public final SqlColumn<Byte> isLock = column("is_lock", JDBCType.TINYINT);

        public final SqlColumn<Byte> isLockAspectRatio = column("is_lock_aspect_ratio", JDBCType.TINYINT);

        public final SqlColumn<String> category = column("category", JDBCType.VARCHAR);

        public final SqlColumn<String> subCategory = column("sub_category", JDBCType.VARCHAR);

        public final SqlColumn<String> umdJsUrl = column("umd_js_url", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdAt = column("created_at", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updatedAt = column("updated_at", JDBCType.TIMESTAMP);

        public final SqlColumn<String> styleLabelConfig = column("style_label_config", JDBCType.LONGVARCHAR);

        public final SqlColumn<String> styleConfig = column("style_config", JDBCType.LONGVARCHAR);

        public final SqlColumn<String> requestConfig = column("request_config", JDBCType.LONGVARCHAR);

        public final SqlColumn<String> interactConfig = column("interact_config", JDBCType.LONGVARCHAR);

        public Component() {
            super("vs_components", Component::new);
        }
    }
}