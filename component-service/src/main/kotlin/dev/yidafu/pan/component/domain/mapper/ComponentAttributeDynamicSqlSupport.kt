package dev.yidafu.pan.component.domain.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object ComponentAttributeDynamicSqlSupport {
    val componentAttribute = ComponentAttribute()

    val id = componentAttribute.id

    val ownerId = componentAttribute.ownerId

    val attr = componentAttribute.attr

    val valueType = componentAttribute.valueType

    val value = componentAttribute.value

    val createdAt = componentAttribute.createdAt

    val updatedAt = componentAttribute.updatedAt

    class ComponentAttribute : AliasableSqlTable<ComponentAttribute>("vs_component_attribute", ::ComponentAttribute) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val ownerId = column<Long>(name = "owner_id", jdbcType = JDBCType.BIGINT)

        val attr = column<String>(name = "attr", jdbcType = JDBCType.VARCHAR)

        val valueType = column<Byte>(name = "value_type", jdbcType = JDBCType.TINYINT)

        val value = column<String>(name = "value", jdbcType = JDBCType.VARCHAR)

        val createdAt = column<Date>(name = "created_at", jdbcType = JDBCType.TIMESTAMP)

        val updatedAt = column<Date>(name = "updated_at", jdbcType = JDBCType.TIMESTAMP)
    }
}