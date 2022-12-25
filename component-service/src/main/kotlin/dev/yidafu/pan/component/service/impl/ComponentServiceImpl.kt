package dev.yidafu.pan.component.service.impl

import com.fasterxml.jackson.databind.node.ObjectNode
import dev.yidafu.pan.component.common.exception.component.ComponentCreateFailException
import dev.yidafu.pan.component.common.exception.component.NonexistentComponentException
import dev.yidafu.pan.component.common.json.JsonUtils
import dev.yidafu.pan.component.common.json.JsonValue
import dev.yidafu.pan.component.convertor.ComponentAttributeConvertor
import dev.yidafu.pan.component.convertor.ComponentConvertor
import dev.yidafu.pan.component.domain.dto.SaveComponentDTO
import dev.yidafu.pan.component.domain.dto.UpdateComponentDTO
import dev.yidafu.pan.component.domain.mapper.ComponentDynamicSqlSupport.component
import dev.yidafu.pan.component.domain.mapper.ComponentMapper
import dev.yidafu.pan.component.domain.mapper.*
import dev.yidafu.pan.component.domain.model.Component
import dev.yidafu.pan.component.domain.vo.ComponentVO
import dev.yidafu.pan.component.service.ComponentAttributeService
import dev.yidafu.pan.component.service.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ComponentServiceImpl : ComponentService {
    @Autowired
    var mapper: ComponentMapper? = null

    @Autowired
    var convertor: ComponentConvertor? = null

    @Autowired
    var attributeConvertor: ComponentAttributeConvertor? = null;

    @Autowired
    var componentAttributeService: ComponentAttributeService? = null

    override fun findById(id: Long): ComponentVO {

        val component = mapper?.selectOne{
            where {
                component.id isEqualTo id
            }
        }
        return  component?.let {
            convertor?.to(it)
        } ?: throw NonexistentComponentException()

    }

    override fun findAllByScreenId(screenId: Long): List<ComponentVO?> {

        val componentList = mapper?.select {
            where {
                component.screenId isEqualTo screenId
            }
        }

        return componentList?.let { convertor?.to(componentList) } ?: Collections.emptyList()
    }

    override fun updateById(id: Long, dto: UpdateComponentDTO): ComponentVO {
        val component: Component = convertor!!.from(dto)

        component.id = id
        mapper?.updateByPrimaryKey(component)
        val root = JsonUtils.createObject();
        root.put("styleConfig", dto.styleConfig);
        root.put("requestConfig", dto.requestConfig);
        root.put("styleLabelConfig", dto.styleLabelConfig);
        root.put("interactConfig", dto.interactConfig);
        updateComponentAttribute(id, root);
        return findById(id)
    }

    override fun createOne(dto: SaveComponentDTO): ComponentVO {
        val component: Component = convertor!!.from(dto)
        mapper?.insert(component)

        return component.id?.let {
            val root = JsonUtils.createObject();
            root.put("styleConfig", dto.styleConfig);
            root.put("requestConfig", dto.requestConfig);
            root.put("styleLabelConfig", dto.styleLabelConfig);
            root.put("interactConfig", dto.interactConfig);
            updateComponentAttribute(it, root);
            findById(it);
        } ?: throw ComponentCreateFailException()
    }

    private fun updateComponentAttribute(comId: Long, obj: ObjectNode) {

        val oldAttrMap = componentAttributeService?.findAllByOwner(comId) ?: Collections.emptyMap();

        val newAttrMap = JsonUtils.toMap(obj);

        val diffResult = diffAttrMap(oldAttrMap, newAttrMap);

        componentAttributeService?.batchCreate(attributeConvertor!!.to(comId, diffResult["create"] ?: Collections.emptyMap()))
        componentAttributeService?.batchUpdateAttr(attributeConvertor!!.toUpdateDTOList(comId, diffResult["update"] ?: Collections.emptyMap()))
        componentAttributeService?.remoteByAttrs(comId, diffResult["remove"]?.keys?.toList() ?: Collections.emptyList());
    }

    private fun diffAttrMap(oldMap: Map<String, JsonValue>, newMap:  Map<String, JsonValue>): Map<String, Map<String, JsonValue>> {
        val updateMap = mutableMapOf<String, JsonValue>();
        val removeMap = mutableMapOf<String, JsonValue>();
        val createMap = mutableMapOf<String, JsonValue>();

        val oldKeys = oldMap.keys
        val newKeys = newMap.keys
        oldMap.forEach {
            if (newKeys.contains(it.key)) {
                if (newMap[it.key]?.equals(it.value) == true) {
                    updateMap[it.key] = newMap[it.key]!!;
                }
            } else {
                removeMap[it.key] = it.value;
            }
        }

        newMap.forEach {
            if (!oldKeys.contains(it.key)) {
                createMap[it.key] = it.value;
            }
        }
        return mapOf<String, Map<String, JsonValue>> (
            "update" to updateMap,
            "create" to createMap,
            "remove" to removeMap
        );
    }
}