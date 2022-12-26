package dev.yidafu.pan.screen.domain.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object ScreenDynamicSqlSupport {
    val screen = Screen()

    val id = screen.id

    val name = screen.name

    val width = screen.width

    val height = screen.height

    val backgroundColor = screen.backgroundColor

    val backgroundImage = screen.backgroundImage

    val snapshotUrl = screen.snapshotUrl

    val fillType = screen.fillType

    val isPublished = screen.isPublished

    val isTemplate = screen.isTemplate

    val createdAt = screen.createdAt

    val updatedAt = screen.updatedAt

    class Screen : AliasableSqlTable<Screen>("vs_screen", ::Screen) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val name = column<String>(name = "name", jdbcType = JDBCType.VARCHAR)

        val width = column<Int>(name = "width", jdbcType = JDBCType.INTEGER)

        val height = column<Int>(name = "height", jdbcType = JDBCType.INTEGER)

        val backgroundColor = column<String>(name = "background_color", jdbcType = JDBCType.VARCHAR)

        val backgroundImage = column<String>(name = "background_image", jdbcType = JDBCType.VARCHAR)

        val snapshotUrl = column<String>(name = "snapshot_url", jdbcType = JDBCType.VARCHAR)

        val fillType = column<Byte>(name = "fill_type", jdbcType = JDBCType.TINYINT)

        val isPublished = column<Byte>(name = "is_published", jdbcType = JDBCType.TINYINT)

        val isTemplate = column<Byte>(name = "is_template", jdbcType = JDBCType.TINYINT)

        val createdAt = column<Date>(name = "created_at", jdbcType = JDBCType.TIMESTAMP)

        val updatedAt = column<Date>(name = "updated_at", jdbcType = JDBCType.TIMESTAMP)
    }
}