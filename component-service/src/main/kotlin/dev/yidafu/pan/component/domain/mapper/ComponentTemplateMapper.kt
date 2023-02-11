package dev.yidafu.pan.component.domain.mapper

import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.category
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.componentTemplate
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.createdAt
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.groupId
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.height
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.id
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.isGroup
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.isLock
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.isLockAspectRatio
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.layerName
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.name
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.offsetX
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.offsetY
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.screenId
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.subCategory
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.umdJsUrl
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.updatedAt
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.width
import dev.yidafu.pan.component.domain.mapper.ComponentTemplateDynamicSqlSupport.zIndex
import dev.yidafu.pan.component.domain.model.ComponentTemplate
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
interface ComponentTemplateMapper : CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @InsertProvider(type = SqlProviderAdapter::class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "row.id")
    fun insert(insertStatement: InsertStatementProvider<ComponentTemplate>): Int

    @InsertProvider(type = SqlProviderAdapter::class, method = "insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys = true, keyProperty = "records.id")
    fun insertMultiple(@Param("insertStatement") insertStatement: String, @Param("records") records: List<ComponentTemplate>): Int

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "ComponentTemplateResult",
        value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "screen_id", property = "screenId", jdbcType = JdbcType.BIGINT),
            Result(column = "group_id", property = "groupId", jdbcType = JdbcType.BIGINT),
            Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            Result(column = "layer_name", property = "layerName", jdbcType = JdbcType.VARCHAR),
            Result(column = "is_group", property = "isGroup", jdbcType = JdbcType.TINYINT),
            Result(column = "width", property = "width", jdbcType = JdbcType.INTEGER),
            Result(column = "height", property = "height", jdbcType = JdbcType.INTEGER),
            Result(column = "offset_x", property = "offsetX", jdbcType = JdbcType.INTEGER),
            Result(column = "offset_y", property = "offsetY", jdbcType = JdbcType.INTEGER),
            Result(column = "z_index", property = "zIndex", jdbcType = JdbcType.INTEGER),
            Result(column = "is_lock", property = "isLock", jdbcType = JdbcType.TINYINT),
            Result(column = "is_lock_aspect_ratio", property = "isLockAspectRatio", jdbcType = JdbcType.TINYINT),
            Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR),
            Result(column = "sub_category", property = "subCategory", jdbcType = JdbcType.VARCHAR),
            Result(column = "umd_js_url", property = "umdJsUrl", jdbcType = JdbcType.VARCHAR),
            Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<ComponentTemplate>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("ComponentTemplateResult")
    fun selectOne(selectStatement: SelectStatementProvider): ComponentTemplate?
}

fun ComponentTemplateMapper.count(completer: CountCompleter) =
    countFrom(this::count, componentTemplate, completer)

fun ComponentTemplateMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, componentTemplate, completer)

fun ComponentTemplateMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun ComponentTemplateMapper.insert(row: ComponentTemplate) =
    insert(this::insert, row, componentTemplate) {
        map(screenId) toProperty "screenId"
        map(groupId) toProperty "groupId"
        map(name) toProperty "name"
        map(layerName) toProperty "layerName"
        map(isGroup) toProperty "isGroup"
        map(width) toProperty "width"
        map(height) toProperty "height"
        map(offsetX) toProperty "offsetX"
        map(offsetY) toProperty "offsetY"
        map(zIndex) toProperty "zIndex"
        map(isLock) toProperty "isLock"
        map(isLockAspectRatio) toProperty "isLockAspectRatio"
        map(category) toProperty "category"
        map(subCategory) toProperty "subCategory"
        map(umdJsUrl) toProperty "umdJsUrl"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
    }

fun ComponentTemplateMapper.insertMultiple(records: Collection<ComponentTemplate>) =
    insertMultipleWithGeneratedKeys(this::insertMultiple, records, componentTemplate) {
        map(screenId) toProperty "screenId"
        map(groupId) toProperty "groupId"
        map(name) toProperty "name"
        map(layerName) toProperty "layerName"
        map(isGroup) toProperty "isGroup"
        map(width) toProperty "width"
        map(height) toProperty "height"
        map(offsetX) toProperty "offsetX"
        map(offsetY) toProperty "offsetY"
        map(zIndex) toProperty "zIndex"
        map(isLock) toProperty "isLock"
        map(isLockAspectRatio) toProperty "isLockAspectRatio"
        map(category) toProperty "category"
        map(subCategory) toProperty "subCategory"
        map(umdJsUrl) toProperty "umdJsUrl"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
    }

fun ComponentTemplateMapper.insertMultiple(vararg records: ComponentTemplate) =
    insertMultiple(records.toList())

fun ComponentTemplateMapper.insertSelective(row: ComponentTemplate) =
    insert(this::insert, row, componentTemplate) {
        map(screenId).toPropertyWhenPresent("screenId", row::screenId)
        map(groupId).toPropertyWhenPresent("groupId", row::groupId)
        map(name).toPropertyWhenPresent("name", row::name)
        map(layerName).toPropertyWhenPresent("layerName", row::layerName)
        map(isGroup).toPropertyWhenPresent("isGroup", row::isGroup)
        map(width).toPropertyWhenPresent("width", row::width)
        map(height).toPropertyWhenPresent("height", row::height)
        map(offsetX).toPropertyWhenPresent("offsetX", row::offsetX)
        map(offsetY).toPropertyWhenPresent("offsetY", row::offsetY)
        map(zIndex).toPropertyWhenPresent("zIndex", row::zIndex)
        map(isLock).toPropertyWhenPresent("isLock", row::isLock)
        map(isLockAspectRatio).toPropertyWhenPresent("isLockAspectRatio", row::isLockAspectRatio)
        map(category).toPropertyWhenPresent("category", row::category)
        map(subCategory).toPropertyWhenPresent("subCategory", row::subCategory)
        map(umdJsUrl).toPropertyWhenPresent("umdJsUrl", row::umdJsUrl)
        map(createdAt).toPropertyWhenPresent("createdAt", row::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", row::updatedAt)
    }

private val columnList = listOf(id, screenId, groupId, name, layerName, isGroup, width, height, offsetX, offsetY, zIndex, isLock, isLockAspectRatio, category, subCategory, umdJsUrl, createdAt, updatedAt)

fun ComponentTemplateMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, componentTemplate, completer)

fun ComponentTemplateMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, componentTemplate, completer)

fun ComponentTemplateMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, componentTemplate, completer)

fun ComponentTemplateMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun ComponentTemplateMapper.update(completer: UpdateCompleter) =
    update(this::update, componentTemplate, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: ComponentTemplate) =
    apply {
        set(screenId) equalToOrNull row::screenId
        set(groupId) equalToOrNull row::groupId
        set(name) equalToOrNull row::name
        set(layerName) equalToOrNull row::layerName
        set(isGroup) equalToOrNull row::isGroup
        set(width) equalToOrNull row::width
        set(height) equalToOrNull row::height
        set(offsetX) equalToOrNull row::offsetX
        set(offsetY) equalToOrNull row::offsetY
        set(zIndex) equalToOrNull row::zIndex
        set(isLock) equalToOrNull row::isLock
        set(isLockAspectRatio) equalToOrNull row::isLockAspectRatio
        set(category) equalToOrNull row::category
        set(subCategory) equalToOrNull row::subCategory
        set(umdJsUrl) equalToOrNull row::umdJsUrl
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: ComponentTemplate) =
    apply {
        set(screenId) equalToWhenPresent row::screenId
        set(groupId) equalToWhenPresent row::groupId
        set(name) equalToWhenPresent row::name
        set(layerName) equalToWhenPresent row::layerName
        set(isGroup) equalToWhenPresent row::isGroup
        set(width) equalToWhenPresent row::width
        set(height) equalToWhenPresent row::height
        set(offsetX) equalToWhenPresent row::offsetX
        set(offsetY) equalToWhenPresent row::offsetY
        set(zIndex) equalToWhenPresent row::zIndex
        set(isLock) equalToWhenPresent row::isLock
        set(isLockAspectRatio) equalToWhenPresent row::isLockAspectRatio
        set(category) equalToWhenPresent row::category
        set(subCategory) equalToWhenPresent row::subCategory
        set(umdJsUrl) equalToWhenPresent row::umdJsUrl
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
    }

fun ComponentTemplateMapper.updateByPrimaryKey(row: ComponentTemplate) =
    update {
        set(screenId) equalToOrNull row::screenId
        set(groupId) equalToOrNull row::groupId
        set(name) equalToOrNull row::name
        set(layerName) equalToOrNull row::layerName
        set(isGroup) equalToOrNull row::isGroup
        set(width) equalToOrNull row::width
        set(height) equalToOrNull row::height
        set(offsetX) equalToOrNull row::offsetX
        set(offsetY) equalToOrNull row::offsetY
        set(zIndex) equalToOrNull row::zIndex
        set(isLock) equalToOrNull row::isLock
        set(isLockAspectRatio) equalToOrNull row::isLockAspectRatio
        set(category) equalToOrNull row::category
        set(subCategory) equalToOrNull row::subCategory
        set(umdJsUrl) equalToOrNull row::umdJsUrl
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
        where { id isEqualTo row.id!! }
    }

fun ComponentTemplateMapper.updateByPrimaryKeySelective(row: ComponentTemplate) =
    update {
        set(screenId) equalToWhenPresent row::screenId
        set(groupId) equalToWhenPresent row::groupId
        set(name) equalToWhenPresent row::name
        set(layerName) equalToWhenPresent row::layerName
        set(isGroup) equalToWhenPresent row::isGroup
        set(width) equalToWhenPresent row::width
        set(height) equalToWhenPresent row::height
        set(offsetX) equalToWhenPresent row::offsetX
        set(offsetY) equalToWhenPresent row::offsetY
        set(zIndex) equalToWhenPresent row::zIndex
        set(isLock) equalToWhenPresent row::isLock
        set(isLockAspectRatio) equalToWhenPresent row::isLockAspectRatio
        set(category) equalToWhenPresent row::category
        set(subCategory) equalToWhenPresent row::subCategory
        set(umdJsUrl) equalToWhenPresent row::umdJsUrl
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
        where { id isEqualTo row.id!! }
    }
