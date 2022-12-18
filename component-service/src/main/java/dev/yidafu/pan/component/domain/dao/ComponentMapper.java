package dev.yidafu.pan.component.domain.dao;

import static dev.yidafu.pan.component.domain.dao.ComponentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import dev.yidafu.pan.component.domain.entity.Component;
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
public interface ComponentMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, screenId, groupId, name, layerName, isGroup, width, height, offsetX, offsetY, zIndex, isLock, isLockAspectRatio, category, subCategory, umdJsUrl, createdAt, updatedAt, styleLabelConfig, styleConfig, requestConfig, interactConfig);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<Component> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Component> records);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ComponentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="screen_id", property="screenId", jdbcType=JdbcType.BIGINT),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="layer_name", property="layerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_group", property="isGroup", jdbcType=JdbcType.TINYINT),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="height", property="height", jdbcType=JdbcType.INTEGER),
        @Result(column="offset_x", property="offsetX", jdbcType=JdbcType.INTEGER),
        @Result(column="offset_y", property="offsetY", jdbcType=JdbcType.INTEGER),
        @Result(column="z_index", property="zIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="is_lock", property="isLock", jdbcType=JdbcType.TINYINT),
        @Result(column="is_lock_aspect_ratio", property="isLockAspectRatio", jdbcType=JdbcType.TINYINT),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_category", property="subCategory", jdbcType=JdbcType.VARCHAR),
        @Result(column="umd_js_url", property="umdJsUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="style_label_config", property="styleLabelConfig", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="style_config", property="styleConfig", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="request_config", property="requestConfig", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="interact_config", property="interactConfig", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Component> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ComponentResult")
    Optional<Component> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, component, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, component, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Component row) {
        return MyBatis3Utils.insert(this::insert, row, component, c ->
            c.map(screenId).toProperty("screenId")
            .map(groupId).toProperty("groupId")
            .map(name).toProperty("name")
            .map(layerName).toProperty("layerName")
            .map(isGroup).toProperty("isGroup")
            .map(width).toProperty("width")
            .map(height).toProperty("height")
            .map(offsetX).toProperty("offsetX")
            .map(offsetY).toProperty("offsetY")
            .map(zIndex).toProperty("zIndex")
            .map(isLock).toProperty("isLock")
            .map(isLockAspectRatio).toProperty("isLockAspectRatio")
            .map(category).toProperty("category")
            .map(subCategory).toProperty("subCategory")
            .map(umdJsUrl).toProperty("umdJsUrl")
            .map(createdAt).toProperty("createdAt")
            .map(updatedAt).toProperty("updatedAt")
            .map(styleLabelConfig).toProperty("styleLabelConfig")
            .map(styleConfig).toProperty("styleConfig")
            .map(requestConfig).toProperty("requestConfig")
            .map(interactConfig).toProperty("interactConfig")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Component> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, component, c ->
            c.map(screenId).toProperty("screenId")
            .map(groupId).toProperty("groupId")
            .map(name).toProperty("name")
            .map(layerName).toProperty("layerName")
            .map(isGroup).toProperty("isGroup")
            .map(width).toProperty("width")
            .map(height).toProperty("height")
            .map(offsetX).toProperty("offsetX")
            .map(offsetY).toProperty("offsetY")
            .map(zIndex).toProperty("zIndex")
            .map(isLock).toProperty("isLock")
            .map(isLockAspectRatio).toProperty("isLockAspectRatio")
            .map(category).toProperty("category")
            .map(subCategory).toProperty("subCategory")
            .map(umdJsUrl).toProperty("umdJsUrl")
            .map(createdAt).toProperty("createdAt")
            .map(updatedAt).toProperty("updatedAt")
            .map(styleLabelConfig).toProperty("styleLabelConfig")
            .map(styleConfig).toProperty("styleConfig")
            .map(requestConfig).toProperty("requestConfig")
            .map(interactConfig).toProperty("interactConfig")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Component row) {
        return MyBatis3Utils.insert(this::insert, row, component, c ->
            c.map(screenId).toPropertyWhenPresent("screenId", row::getScreenId)
            .map(groupId).toPropertyWhenPresent("groupId", row::getGroupId)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(layerName).toPropertyWhenPresent("layerName", row::getLayerName)
            .map(isGroup).toPropertyWhenPresent("isGroup", row::getIsGroup)
            .map(width).toPropertyWhenPresent("width", row::getWidth)
            .map(height).toPropertyWhenPresent("height", row::getHeight)
            .map(offsetX).toPropertyWhenPresent("offsetX", row::getOffsetX)
            .map(offsetY).toPropertyWhenPresent("offsetY", row::getOffsetY)
            .map(zIndex).toPropertyWhenPresent("zIndex", row::getzIndex)
            .map(isLock).toPropertyWhenPresent("isLock", row::getIsLock)
            .map(isLockAspectRatio).toPropertyWhenPresent("isLockAspectRatio", row::getIsLockAspectRatio)
            .map(category).toPropertyWhenPresent("category", row::getCategory)
            .map(subCategory).toPropertyWhenPresent("subCategory", row::getSubCategory)
            .map(umdJsUrl).toPropertyWhenPresent("umdJsUrl", row::getUmdJsUrl)
            .map(createdAt).toPropertyWhenPresent("createdAt", row::getCreatedAt)
            .map(updatedAt).toPropertyWhenPresent("updatedAt", row::getUpdatedAt)
            .map(styleLabelConfig).toPropertyWhenPresent("styleLabelConfig", row::getStyleLabelConfig)
            .map(styleConfig).toPropertyWhenPresent("styleConfig", row::getStyleConfig)
            .map(requestConfig).toPropertyWhenPresent("requestConfig", row::getRequestConfig)
            .map(interactConfig).toPropertyWhenPresent("interactConfig", row::getInteractConfig)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Component> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, component, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Component> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, component, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Component> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, component, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Component> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, component, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Component row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(screenId).equalTo(row::getScreenId)
                .set(groupId).equalTo(row::getGroupId)
                .set(name).equalTo(row::getName)
                .set(layerName).equalTo(row::getLayerName)
                .set(isGroup).equalTo(row::getIsGroup)
                .set(width).equalTo(row::getWidth)
                .set(height).equalTo(row::getHeight)
                .set(offsetX).equalTo(row::getOffsetX)
                .set(offsetY).equalTo(row::getOffsetY)
                .set(zIndex).equalTo(row::getzIndex)
                .set(isLock).equalTo(row::getIsLock)
                .set(isLockAspectRatio).equalTo(row::getIsLockAspectRatio)
                .set(category).equalTo(row::getCategory)
                .set(subCategory).equalTo(row::getSubCategory)
                .set(umdJsUrl).equalTo(row::getUmdJsUrl)
                .set(createdAt).equalTo(row::getCreatedAt)
                .set(updatedAt).equalTo(row::getUpdatedAt)
                .set(styleLabelConfig).equalTo(row::getStyleLabelConfig)
                .set(styleConfig).equalTo(row::getStyleConfig)
                .set(requestConfig).equalTo(row::getRequestConfig)
                .set(interactConfig).equalTo(row::getInteractConfig);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Component row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(screenId).equalToWhenPresent(row::getScreenId)
                .set(groupId).equalToWhenPresent(row::getGroupId)
                .set(name).equalToWhenPresent(row::getName)
                .set(layerName).equalToWhenPresent(row::getLayerName)
                .set(isGroup).equalToWhenPresent(row::getIsGroup)
                .set(width).equalToWhenPresent(row::getWidth)
                .set(height).equalToWhenPresent(row::getHeight)
                .set(offsetX).equalToWhenPresent(row::getOffsetX)
                .set(offsetY).equalToWhenPresent(row::getOffsetY)
                .set(zIndex).equalToWhenPresent(row::getzIndex)
                .set(isLock).equalToWhenPresent(row::getIsLock)
                .set(isLockAspectRatio).equalToWhenPresent(row::getIsLockAspectRatio)
                .set(category).equalToWhenPresent(row::getCategory)
                .set(subCategory).equalToWhenPresent(row::getSubCategory)
                .set(umdJsUrl).equalToWhenPresent(row::getUmdJsUrl)
                .set(createdAt).equalToWhenPresent(row::getCreatedAt)
                .set(updatedAt).equalToWhenPresent(row::getUpdatedAt)
                .set(styleLabelConfig).equalToWhenPresent(row::getStyleLabelConfig)
                .set(styleConfig).equalToWhenPresent(row::getStyleConfig)
                .set(requestConfig).equalToWhenPresent(row::getRequestConfig)
                .set(interactConfig).equalToWhenPresent(row::getInteractConfig);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Component row) {
        return update(c ->
            c.set(screenId).equalTo(row::getScreenId)
            .set(groupId).equalTo(row::getGroupId)
            .set(name).equalTo(row::getName)
            .set(layerName).equalTo(row::getLayerName)
            .set(isGroup).equalTo(row::getIsGroup)
            .set(width).equalTo(row::getWidth)
            .set(height).equalTo(row::getHeight)
            .set(offsetX).equalTo(row::getOffsetX)
            .set(offsetY).equalTo(row::getOffsetY)
            .set(zIndex).equalTo(row::getzIndex)
            .set(isLock).equalTo(row::getIsLock)
            .set(isLockAspectRatio).equalTo(row::getIsLockAspectRatio)
            .set(category).equalTo(row::getCategory)
            .set(subCategory).equalTo(row::getSubCategory)
            .set(umdJsUrl).equalTo(row::getUmdJsUrl)
            .set(createdAt).equalTo(row::getCreatedAt)
            .set(updatedAt).equalTo(row::getUpdatedAt)
            .set(styleLabelConfig).equalTo(row::getStyleLabelConfig)
            .set(styleConfig).equalTo(row::getStyleConfig)
            .set(requestConfig).equalTo(row::getRequestConfig)
            .set(interactConfig).equalTo(row::getInteractConfig)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Component row) {
        return update(c ->
            c.set(screenId).equalToWhenPresent(row::getScreenId)
            .set(groupId).equalToWhenPresent(row::getGroupId)
            .set(name).equalToWhenPresent(row::getName)
            .set(layerName).equalToWhenPresent(row::getLayerName)
            .set(isGroup).equalToWhenPresent(row::getIsGroup)
            .set(width).equalToWhenPresent(row::getWidth)
            .set(height).equalToWhenPresent(row::getHeight)
            .set(offsetX).equalToWhenPresent(row::getOffsetX)
            .set(offsetY).equalToWhenPresent(row::getOffsetY)
            .set(zIndex).equalToWhenPresent(row::getzIndex)
            .set(isLock).equalToWhenPresent(row::getIsLock)
            .set(isLockAspectRatio).equalToWhenPresent(row::getIsLockAspectRatio)
            .set(category).equalToWhenPresent(row::getCategory)
            .set(subCategory).equalToWhenPresent(row::getSubCategory)
            .set(umdJsUrl).equalToWhenPresent(row::getUmdJsUrl)
            .set(createdAt).equalToWhenPresent(row::getCreatedAt)
            .set(updatedAt).equalToWhenPresent(row::getUpdatedAt)
            .set(styleLabelConfig).equalToWhenPresent(row::getStyleLabelConfig)
            .set(styleConfig).equalToWhenPresent(row::getStyleConfig)
            .set(requestConfig).equalToWhenPresent(row::getRequestConfig)
            .set(interactConfig).equalToWhenPresent(row::getInteractConfig)
            .where(id, isEqualTo(row::getId))
        );
    }
}