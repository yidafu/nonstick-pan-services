package dev.yidafu.pan.component.domain.dao

import dev.yidafu.pan.component.domain.dao.ComponentAttributeDynamicSqlSupport.attr
import dev.yidafu.pan.component.domain.dao.ComponentAttributeDynamicSqlSupport.componentAttribute
import dev.yidafu.pan.component.domain.dao.ComponentAttributeDynamicSqlSupport.createdAt
import dev.yidafu.pan.component.domain.dao.ComponentAttributeDynamicSqlSupport.id
import dev.yidafu.pan.component.domain.dao.ComponentAttributeDynamicSqlSupport.ownerId
import dev.yidafu.pan.component.domain.dao.ComponentAttributeDynamicSqlSupport.updatedAt
import dev.yidafu.pan.component.domain.dao.ComponentAttributeDynamicSqlSupport.value
import dev.yidafu.pan.component.domain.dao.ComponentAttributeDynamicSqlSupport.valueType
import dev.yidafu.pan.component.domain.entity.ComponentAttribute
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
interface ComponentAttributeMapper : CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @InsertProvider(type=SqlProviderAdapter::class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    fun insert(insertStatement: InsertStatementProvider<ComponentAttribute>): Int

    @InsertProvider(type = SqlProviderAdapter::class, method = "insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    fun insertMultiple(@Param("insertStatement") insertStatement: String, @Param("records") records: List<ComponentAttribute>): Int

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="ComponentAttributeResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="owner_id", property="ownerId", jdbcType=JdbcType.BIGINT),
        Result(column="attr", property="attr", jdbcType=JdbcType.VARCHAR),
        Result(column="value_type", property="valueType", jdbcType=JdbcType.TINYINT),
        Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<ComponentAttribute>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("ComponentAttributeResult")
    fun selectOne(selectStatement: SelectStatementProvider): ComponentAttribute?
}

fun ComponentAttributeMapper.count(completer: CountCompleter) =
    countFrom(this::count, componentAttribute, completer)

fun ComponentAttributeMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, componentAttribute, completer)

fun ComponentAttributeMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun ComponentAttributeMapper.insert(row: ComponentAttribute) =
    insert(this::insert, row, componentAttribute) {
        map(ownerId) toProperty "ownerId"
        map(attr) toProperty "attr"
        map(valueType) toProperty "valueType"
        map(value) toProperty "value"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
    }

fun ComponentAttributeMapper.insertMultiple(records: Collection<ComponentAttribute>) =
    insertMultipleWithGeneratedKeys(this::insertMultiple, records, componentAttribute) {
        map(ownerId) toProperty "ownerId"
        map(attr) toProperty "attr"
        map(valueType) toProperty "valueType"
        map(value) toProperty "value"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
    }

fun ComponentAttributeMapper.insertMultiple(vararg records: ComponentAttribute) =
    insertMultiple(records.toList())

fun ComponentAttributeMapper.insertSelective(row: ComponentAttribute) =
    insert(this::insert, row, componentAttribute) {
        map(ownerId).toPropertyWhenPresent("ownerId", row::ownerId)
        map(attr).toPropertyWhenPresent("attr", row::attr)
        map(valueType).toPropertyWhenPresent("valueType", row::valueType)
        map(value).toPropertyWhenPresent("value", row::value)
        map(createdAt).toPropertyWhenPresent("createdAt", row::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", row::updatedAt)
    }

private val columnList = listOf(id, ownerId, attr, valueType, value, createdAt, updatedAt)

fun ComponentAttributeMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, componentAttribute, completer)

fun ComponentAttributeMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, componentAttribute, completer)

fun ComponentAttributeMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, componentAttribute, completer)

fun ComponentAttributeMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun ComponentAttributeMapper.update(completer: UpdateCompleter) =
    update(this::update, componentAttribute, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: ComponentAttribute) =
    apply {
        set(ownerId) equalToOrNull row::ownerId
        set(attr) equalToOrNull row::attr
        set(valueType) equalToOrNull row::valueType
        set(value) equalToOrNull row::value
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: ComponentAttribute) =
    apply {
        set(ownerId) equalToWhenPresent row::ownerId
        set(attr) equalToWhenPresent row::attr
        set(valueType) equalToWhenPresent row::valueType
        set(value) equalToWhenPresent row::value
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
    }

fun ComponentAttributeMapper.updateByPrimaryKey(row: ComponentAttribute) =
    update {
        set(ownerId) equalToOrNull row::ownerId
        set(attr) equalToOrNull row::attr
        set(valueType) equalToOrNull row::valueType
        set(value) equalToOrNull row::value
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
        where { id isEqualTo row.id!! }
    }

fun ComponentAttributeMapper.updateByPrimaryKeySelective(row: ComponentAttribute) =
    update {
        set(ownerId) equalToWhenPresent row::ownerId
        set(attr) equalToWhenPresent row::attr
        set(valueType) equalToWhenPresent row::valueType
        set(value) equalToWhenPresent row::value
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
        where { id isEqualTo row.id!! }
    }