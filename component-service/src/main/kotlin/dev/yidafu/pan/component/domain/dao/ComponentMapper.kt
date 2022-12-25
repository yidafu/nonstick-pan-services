package dev.yidafu.pan.component.domain.dao

import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.category
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.component
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.createdAt
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.groupId
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.height
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.id
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.interactConfig
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.isGroup
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.isLock
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.isLockAspectRatio
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.layerName
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.name
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.offsetX
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.offsetY
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.requestConfig
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.screenId
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.styleConfig
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.styleLabelConfig
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.subCategory
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.umdJsUrl
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.updatedAt
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.width
import dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.zIndex
import dev.yidafu.pan.component.domain.entity.Component
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
interface ComponentMapper : CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @InsertProvider(type=SqlProviderAdapter::class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    fun insert(insertStatement: InsertStatementProvider<Component>): Int

    @InsertProvider(type = SqlProviderAdapter::class, method = "insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    fun insertMultiple(@Param("insertStatement") insertStatement: String, @Param("records") records: List<Component>): Int

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="ComponentResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="screen_id", property="screenId", jdbcType=JdbcType.BIGINT),
        Result(column="group_id", property="groupId", jdbcType=JdbcType.BIGINT),
        Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        Result(column="layer_name", property="layerName", jdbcType=JdbcType.VARCHAR),
        Result(column="is_group", property="isGroup", jdbcType=JdbcType.TINYINT),
        Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        Result(column="height", property="height", jdbcType=JdbcType.INTEGER),
        Result(column="offset_x", property="offsetX", jdbcType=JdbcType.INTEGER),
        Result(column="offset_y", property="offsetY", jdbcType=JdbcType.INTEGER),
        Result(column="z_index", property="zIndex", jdbcType=JdbcType.INTEGER),
        Result(column="is_lock", property="isLock", jdbcType=JdbcType.TINYINT),
        Result(column="is_lock_aspect_ratio", property="isLockAspectRatio", jdbcType=JdbcType.TINYINT),
        Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        Result(column="sub_category", property="subCategory", jdbcType=JdbcType.VARCHAR),
        Result(column="umd_js_url", property="umdJsUrl", jdbcType=JdbcType.VARCHAR),
        Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="style_label_config", property="styleLabelConfig", jdbcType=JdbcType.LONGVARCHAR),
        Result(column="style_config", property="styleConfig", jdbcType=JdbcType.LONGVARCHAR),
        Result(column="request_config", property="requestConfig", jdbcType=JdbcType.LONGVARCHAR),
        Result(column="interact_config", property="interactConfig", jdbcType=JdbcType.LONGVARCHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Component>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("ComponentResult")
    fun selectOne(selectStatement: SelectStatementProvider): Component?
}

fun ComponentMapper.count(completer: CountCompleter) =
    countFrom(this::count, component, completer)

fun ComponentMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, component, completer)

fun ComponentMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun ComponentMapper.insert(row: Component) =
    insert(this::insert, row, component) {
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
        map(styleLabelConfig) toProperty "styleLabelConfig"
        map(styleConfig) toProperty "styleConfig"
        map(requestConfig) toProperty "requestConfig"
        map(interactConfig) toProperty "interactConfig"
    }

fun ComponentMapper.insertMultiple(records: Collection<Component>) =
    insertMultipleWithGeneratedKeys(this::insertMultiple, records, component) {
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
        map(styleLabelConfig) toProperty "styleLabelConfig"
        map(styleConfig) toProperty "styleConfig"
        map(requestConfig) toProperty "requestConfig"
        map(interactConfig) toProperty "interactConfig"
    }

fun ComponentMapper.insertMultiple(vararg records: Component) =
    insertMultiple(records.toList())

fun ComponentMapper.insertSelective(row: Component) =
    insert(this::insert, row, component) {
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
        map(styleLabelConfig).toPropertyWhenPresent("styleLabelConfig", row::styleLabelConfig)
        map(styleConfig).toPropertyWhenPresent("styleConfig", row::styleConfig)
        map(requestConfig).toPropertyWhenPresent("requestConfig", row::requestConfig)
        map(interactConfig).toPropertyWhenPresent("interactConfig", row::interactConfig)
    }

private val columnList = listOf(id, screenId, groupId, name, layerName, isGroup, width, height, offsetX, offsetY, zIndex, isLock, isLockAspectRatio, category, subCategory, umdJsUrl, createdAt, updatedAt, styleLabelConfig, styleConfig, requestConfig, interactConfig)

fun ComponentMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, component, completer)

fun ComponentMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, component, completer)

fun ComponentMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, component, completer)

fun ComponentMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun ComponentMapper.update(completer: UpdateCompleter) =
    update(this::update, component, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Component) =
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
        set(styleLabelConfig) equalToOrNull row::styleLabelConfig
        set(styleConfig) equalToOrNull row::styleConfig
        set(requestConfig) equalToOrNull row::requestConfig
        set(interactConfig) equalToOrNull row::interactConfig
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Component) =
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
        set(styleLabelConfig) equalToWhenPresent row::styleLabelConfig
        set(styleConfig) equalToWhenPresent row::styleConfig
        set(requestConfig) equalToWhenPresent row::requestConfig
        set(interactConfig) equalToWhenPresent row::interactConfig
    }

fun ComponentMapper.updateByPrimaryKey(row: Component) =
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
        set(styleLabelConfig) equalToOrNull row::styleLabelConfig
        set(styleConfig) equalToOrNull row::styleConfig
        set(requestConfig) equalToOrNull row::requestConfig
        set(interactConfig) equalToOrNull row::interactConfig
        where { id isEqualTo row.id!! }
    }

fun ComponentMapper.updateByPrimaryKeySelective(row: Component) =
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
        set(styleLabelConfig) equalToWhenPresent row::styleLabelConfig
        set(styleConfig) equalToWhenPresent row::styleConfig
        set(requestConfig) equalToWhenPresent row::requestConfig
        set(interactConfig) equalToWhenPresent row::interactConfig
        where { id isEqualTo row.id!! }
    }