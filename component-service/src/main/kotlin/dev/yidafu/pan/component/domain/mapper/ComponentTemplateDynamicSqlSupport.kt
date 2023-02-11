package dev.yidafu.pan.component.domain.mapper

import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType
import java.util.Date

object ComponentTemplateDynamicSqlSupport {
    val componentTemplate = ComponentTemplate()

    val id = componentTemplate.id

    val screenId = componentTemplate.screenId

    val groupId = componentTemplate.groupId

    val name = componentTemplate.name

    val layerName = componentTemplate.layerName

    val isGroup = componentTemplate.isGroup

    val width = componentTemplate.width

    val height = componentTemplate.height

    val offsetX = componentTemplate.offsetX

    val offsetY = componentTemplate.offsetY

    val zIndex = componentTemplate.zIndex

    val isLock = componentTemplate.isLock

    val isLockAspectRatio = componentTemplate.isLockAspectRatio

    val category = componentTemplate.category

    val subCategory = componentTemplate.subCategory

    val umdJsUrl = componentTemplate.umdJsUrl

    val createdAt = componentTemplate.createdAt

    val updatedAt = componentTemplate.updatedAt

    class ComponentTemplate : AliasableSqlTable<ComponentTemplate>("vs_component_template", ::ComponentTemplate) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val screenId = column<Long>(name = "screen_id", jdbcType = JDBCType.BIGINT)

        val groupId = column<Long>(name = "group_id", jdbcType = JDBCType.BIGINT)

        val name = column<String>(name = "name", jdbcType = JDBCType.VARCHAR)

        val layerName = column<String>(name = "layer_name", jdbcType = JDBCType.VARCHAR)

        val isGroup = column<Byte>(name = "is_group", jdbcType = JDBCType.TINYINT)

        val width = column<Int>(name = "width", jdbcType = JDBCType.INTEGER)

        val height = column<Int>(name = "height", jdbcType = JDBCType.INTEGER)

        val offsetX = column<Int>(name = "offset_x", jdbcType = JDBCType.INTEGER)

        val offsetY = column<Int>(name = "offset_y", jdbcType = JDBCType.INTEGER)

        val zIndex = column<Int>(name = "z_index", jdbcType = JDBCType.INTEGER)

        val isLock = column<Byte>(name = "is_lock", jdbcType = JDBCType.TINYINT)

        val isLockAspectRatio = column<Byte>(name = "is_lock_aspect_ratio", jdbcType = JDBCType.TINYINT)

        val category = column<String>(name = "category", jdbcType = JDBCType.VARCHAR)

        val subCategory = column<String>(name = "sub_category", jdbcType = JDBCType.VARCHAR)

        val umdJsUrl = column<String>(name = "umd_js_url", jdbcType = JDBCType.VARCHAR)

        val createdAt = column<Date>(name = "created_at", jdbcType = JDBCType.TIMESTAMP)

        val updatedAt = column<Date>(name = "updated_at", jdbcType = JDBCType.TIMESTAMP)
    }
}
