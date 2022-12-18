package dev.yidafu.pan.component.domain.dao;

import static dev.yidafu.pan.component.domain.dao.ComponentAttributeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import dev.yidafu.pan.component.domain.entity.ComponentAttribute;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface ComponentAttributeMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, ownerId, attr, valueType, value, createdAt, updatedAt);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<ComponentAttribute> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ComponentAttribute> records);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ComponentAttributeResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="owner_id", property="ownerId", jdbcType=JdbcType.BIGINT),
        @Result(column="attr", property="attr", jdbcType=JdbcType.VARCHAR),
        @Result(column="value_type", property="valueType", jdbcType=JdbcType.TINYINT),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ComponentAttribute> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ComponentAttributeResult")
    Optional<ComponentAttribute> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, componentAttribute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, componentAttribute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ComponentAttribute row) {
        return MyBatis3Utils.insert(this::insert, row, componentAttribute, c ->
            c.map(ownerId).toProperty("ownerId")
            .map(attr).toProperty("attr")
            .map(valueType).toProperty("valueType")
            .map(value).toProperty("value")
            .map(createdAt).toProperty("createdAt")
            .map(updatedAt).toProperty("updatedAt")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ComponentAttribute> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, componentAttribute, c ->
            c.map(ownerId).toProperty("ownerId")
            .map(attr).toProperty("attr")
            .map(valueType).toProperty("valueType")
            .map(value).toProperty("value")
            .map(createdAt).toProperty("createdAt")
            .map(updatedAt).toProperty("updatedAt")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ComponentAttribute row) {
        return MyBatis3Utils.insert(this::insert, row, componentAttribute, c ->
            c.map(ownerId).toPropertyWhenPresent("ownerId", row::getOwnerId)
            .map(attr).toPropertyWhenPresent("attr", row::getAttr)
            .map(valueType).toPropertyWhenPresent("valueType", row::getValueType)
            .map(value).toPropertyWhenPresent("value", row::getValue)
            .map(createdAt).toPropertyWhenPresent("createdAt", row::getCreatedAt)
            .map(updatedAt).toPropertyWhenPresent("updatedAt", row::getUpdatedAt)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ComponentAttribute> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, componentAttribute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ComponentAttribute> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, componentAttribute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ComponentAttribute> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, componentAttribute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ComponentAttribute> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, componentAttribute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ComponentAttribute row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ownerId).equalTo(row::getOwnerId)
                .set(attr).equalTo(row::getAttr)
                .set(valueType).equalTo(row::getValueType)
                .set(value).equalTo(row::getValue)
                .set(createdAt).equalTo(row::getCreatedAt)
                .set(updatedAt).equalTo(row::getUpdatedAt);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ComponentAttribute row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ownerId).equalToWhenPresent(row::getOwnerId)
                .set(attr).equalToWhenPresent(row::getAttr)
                .set(valueType).equalToWhenPresent(row::getValueType)
                .set(value).equalToWhenPresent(row::getValue)
                .set(createdAt).equalToWhenPresent(row::getCreatedAt)
                .set(updatedAt).equalToWhenPresent(row::getUpdatedAt);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ComponentAttribute row) {
        return update(c ->
            c.set(ownerId).equalTo(row::getOwnerId)
            .set(attr).equalTo(row::getAttr)
            .set(valueType).equalTo(row::getValueType)
            .set(value).equalTo(row::getValue)
            .set(createdAt).equalTo(row::getCreatedAt)
            .set(updatedAt).equalTo(row::getUpdatedAt)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ComponentAttribute row) {
        return update(c ->
            c.set(ownerId).equalToWhenPresent(row::getOwnerId)
            .set(attr).equalToWhenPresent(row::getAttr)
            .set(valueType).equalToWhenPresent(row::getValueType)
            .set(value).equalToWhenPresent(row::getValue)
            .set(createdAt).equalToWhenPresent(row::getCreatedAt)
            .set(updatedAt).equalToWhenPresent(row::getUpdatedAt)
            .where(id, isEqualTo(row::getId))
        );
    }
}