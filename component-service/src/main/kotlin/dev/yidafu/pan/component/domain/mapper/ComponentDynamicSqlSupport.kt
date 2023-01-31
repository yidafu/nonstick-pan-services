package dev.yidafu.pan.component.domain.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object ComponentDynamicSqlSupport {
    val component = Component()

    val id = component.id

    val screenId = component.screenId

    val groupId = component.groupId

    val name = component.name

    val layerName = component.layerName

    val isGroup = component.isGroup

    val width = component.width

    val height = component.height

    val offsetX = component.offsetX

    val offsetY = component.offsetY

    val zIndex = component.zIndex

    val isLock = component.isLock

    val isLockAspectRatio = component.isLockAspectRatio

    val category = component.category

    val subCategory = component.subCategory

    val umdJsUrl = component.umdJsUrl

    val createdAt = component.createdAt

    val updatedAt = component.updatedAt

    class Component : AliasableSqlTable<Component>("vs_component", ComponentDynamicSqlSupport::Component) {
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