package dev.yidafu.pan.component.domain.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ComponentAttributeDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ComponentAttribute componentAttribute = new ComponentAttribute();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = componentAttribute.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> owerId = componentAttribute.owerId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> attr = componentAttribute.attr;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> valueType = componentAttribute.valueType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> value = componentAttribute.value;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createdAt = componentAttribute.createdAt;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updatedAt = componentAttribute.updatedAt;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ComponentAttribute extends AliasableSqlTable<ComponentAttribute> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> owerId = column("ower_id", JDBCType.BIGINT);

        public final SqlColumn<String> attr = column("attr", JDBCType.VARCHAR);

        public final SqlColumn<Byte> valueType = column("value_type", JDBCType.TINYINT);

        public final SqlColumn<String> value = column("value", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdAt = column("created_at", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updatedAt = column("updated_at", JDBCType.TIMESTAMP);

        public ComponentAttribute() {
            super("vs_component_attribute", ComponentAttribute::new);
        }
    }
}