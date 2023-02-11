package dev.yidafu.pan.screen.domain.mapper

import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.backgroundColor
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.backgroundImage
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.createdAt
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.fillType
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.height
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.id
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.isPublished
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.isTemplate
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.name
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.screen
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.snapshotUrl
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.updatedAt
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.width
import dev.yidafu.pan.screen.domain.model.Screen
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.CountCompleter
import org.mybatis.dynamic.sql.util.kotlin.DeleteCompleter
import org.mybatis.dynamic.sql.util.kotlin.KotlinUpdateBuilder
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.UpdateCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.countFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.deleteFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insert
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insertMultipleWithGeneratedKeys
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectDistinct
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.update
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface ScreenMapper : CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @InsertProvider(type = SqlProviderAdapter::class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "row.id")
    fun insert(insertStatement: InsertStatementProvider<Screen>): Int

    @InsertProvider(type = SqlProviderAdapter::class, method = "insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys = true, keyProperty = "records.id")
    fun insertMultiple(@Param("insertStatement") insertStatement: String, @Param("records") records: List<Screen>): Int

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "ScreenResult",
        value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            Result(column = "width", property = "width", jdbcType = JdbcType.INTEGER),
            Result(column = "height", property = "height", jdbcType = JdbcType.INTEGER),
            Result(column = "background_color", property = "backgroundColor", jdbcType = JdbcType.VARCHAR),
            Result(column = "background_image", property = "backgroundImage", jdbcType = JdbcType.VARCHAR),
            Result(column = "snapshot_url", property = "snapshotUrl", jdbcType = JdbcType.VARCHAR),
            Result(column = "fill_type", property = "fillType", jdbcType = JdbcType.TINYINT),
            Result(column = "is_published", property = "isPublished", jdbcType = JdbcType.TINYINT),
            Result(column = "is_template", property = "isTemplate", jdbcType = JdbcType.TINYINT),
            Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<Screen>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("ScreenResult")
    fun selectOne(selectStatement: SelectStatementProvider): Screen?
}

fun ScreenMapper.count(completer: CountCompleter) =
    countFrom(this::count, screen, completer)

fun ScreenMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, screen, completer)

fun ScreenMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun ScreenMapper.insert(row: Screen) =
    insert(this::insert, row, screen) {
        map(name) toProperty "name"
        map(width) toProperty "width"
        map(height) toProperty "height"
        map(backgroundColor) toProperty "backgroundColor"
        map(backgroundImage) toProperty "backgroundImage"
        map(snapshotUrl) toProperty "snapshotUrl"
        map(fillType) toProperty "fillType"
        map(isPublished) toProperty "isPublished"
        map(isTemplate) toProperty "isTemplate"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
    }

fun ScreenMapper.insertMultiple(records: Collection<Screen>) =
    insertMultipleWithGeneratedKeys(this::insertMultiple, records, screen) {
        map(name) toProperty "name"
        map(width) toProperty "width"
        map(height) toProperty "height"
        map(backgroundColor) toProperty "backgroundColor"
        map(backgroundImage) toProperty "backgroundImage"
        map(snapshotUrl) toProperty "snapshotUrl"
        map(fillType) toProperty "fillType"
        map(isPublished) toProperty "isPublished"
        map(isTemplate) toProperty "isTemplate"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
    }

fun ScreenMapper.insertMultiple(vararg records: Screen) =
    insertMultiple(records.toList())

fun ScreenMapper.insertSelective(row: Screen) =
    insert(this::insert, row, screen) {
        map(name).toPropertyWhenPresent("name", row::name)
        map(width).toPropertyWhenPresent("width", row::width)
        map(height).toPropertyWhenPresent("height", row::height)
        map(backgroundColor).toPropertyWhenPresent("backgroundColor", row::backgroundColor)
        map(backgroundImage).toPropertyWhenPresent("backgroundImage", row::backgroundImage)
        map(snapshotUrl).toPropertyWhenPresent("snapshotUrl", row::snapshotUrl)
        map(fillType).toPropertyWhenPresent("fillType", row::fillType)
        map(isPublished).toPropertyWhenPresent("isPublished", row::isPublished)
        map(isTemplate).toPropertyWhenPresent("isTemplate", row::isTemplate)
        map(createdAt).toPropertyWhenPresent("createdAt", row::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", row::updatedAt)
    }

private val columnList = listOf(id, name, width, height, backgroundColor, backgroundImage, snapshotUrl, fillType, isPublished, isTemplate, createdAt, updatedAt)

fun ScreenMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, screen, completer)

fun ScreenMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, screen, completer)

fun ScreenMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, screen, completer)

fun ScreenMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun ScreenMapper.update(completer: UpdateCompleter) =
    update(this::update, screen, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Screen) =
    apply {
        set(name) equalToOrNull row::name
        set(width) equalToOrNull row::width
        set(height) equalToOrNull row::height
        set(backgroundColor) equalToOrNull row::backgroundColor
        set(backgroundImage) equalToOrNull row::backgroundImage
        set(snapshotUrl) equalToOrNull row::snapshotUrl
        set(fillType) equalToOrNull row::fillType
        set(isPublished) equalToOrNull row::isPublished
        set(isTemplate) equalToOrNull row::isTemplate
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Screen) =
    apply {
        set(name) equalToWhenPresent row::name
        set(width) equalToWhenPresent row::width
        set(height) equalToWhenPresent row::height
        set(backgroundColor) equalToWhenPresent row::backgroundColor
        set(backgroundImage) equalToWhenPresent row::backgroundImage
        set(snapshotUrl) equalToWhenPresent row::snapshotUrl
        set(fillType) equalToWhenPresent row::fillType
        set(isPublished) equalToWhenPresent row::isPublished
        set(isTemplate) equalToWhenPresent row::isTemplate
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
    }

fun ScreenMapper.updateByPrimaryKey(row: Screen) =
    update {
        set(name) equalToOrNull row::name
        set(width) equalToOrNull row::width
        set(height) equalToOrNull row::height
        set(backgroundColor) equalToOrNull row::backgroundColor
        set(backgroundImage) equalToOrNull row::backgroundImage
        set(snapshotUrl) equalToOrNull row::snapshotUrl
        set(fillType) equalToOrNull row::fillType
        set(isPublished) equalToOrNull row::isPublished
        set(isTemplate) equalToOrNull row::isTemplate
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
        where { id isEqualTo row.id!! }
    }

fun ScreenMapper.updateByPrimaryKeySelective(row: Screen) =
    update {
        set(name) equalToWhenPresent row::name
        set(width) equalToWhenPresent row::width
        set(height) equalToWhenPresent row::height
        set(backgroundColor) equalToWhenPresent row::backgroundColor
        set(backgroundImage) equalToWhenPresent row::backgroundImage
        set(snapshotUrl) equalToWhenPresent row::snapshotUrl
        set(fillType) equalToWhenPresent row::fillType
        set(isPublished) equalToWhenPresent row::isPublished
        set(isTemplate) equalToWhenPresent row::isTemplate
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
        where { id isEqualTo row.id!! }
    }
