package dev.yidafu.pan.component.impl

import com.fasterxml.jackson.databind.node.ObjectNode
import dev.yidafu.pan.common.exception.component.ComponentCreateFailException
import dev.yidafu.pan.common.exception.component.NonexistentComponentException
import dev.yidafu.pan.common.json.JsonUtils
import dev.yidafu.pan.common.json.JsonValue
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

        val comp = mapper?.selectOne{
            where {
                component.id isEqualTo id
            }
        }
        return  comp?.let { it ->
            val vo = convertor?.to(it)
            val attrMap = componentAttributeService?.findAllByOwner(id);
            val attrObj = attrMap?.let { it1 -> JsonUtils.parseMap(it1) };
            attrObj?.let {
                it2 ->
                vo?.styleConfig = it2.get("styleConfig") as ObjectNode?
                vo?.requestConfig = it2.get("requestConfig") as ObjectNode?
                vo?.styleLabelConfig = it2.get("styleLabelConfig") as ObjectNode?
                vo?.interactConfig = it2.get("interactConfig") as ObjectNode?
            }
            vo;
        } ?: throw NonexistentComponentException()

    }

    override fun findAllByScreenId(screenId: Long): List<ComponentVO?> {

        val componentList = mapper?.select {
            where {
                component.screenId isEqualTo screenId
            }
        }
        val comIdList = componentList?.filter { it.id != null }?.map { it.id!! } ?: emptyList()
        val comAttrMap = componentAttributeService?.findAllByOwnerList(comIdList)
        return componentList
            ?.let { convertor?.to(componentList) }
            ?.map {
                val attrObj = comAttrMap?.get(it.id)?.let { it1 -> JsonUtils.parseMap(it1) }
                it.styleConfig = attrObj?.get("styleConfig") as ObjectNode?
                it.requestConfig = attrObj?.get("requestConfig") as ObjectNode?
                it.styleLabelConfig = attrObj?.get("styleLabelConfig") as ObjectNode?
                it.interactConfig = attrObj?.get("interactConfig") as ObjectNode?
                it
            } ?: Collections.emptyList()
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
        val res = mapper?.insertSelective(component)

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

    private fun updateComponentAttribute(comId: Long, obj: ObjectNode): ObjectNode {

        val oldAttrMap = componentAttributeService?.findAllByOwner(comId) ?: Collections.emptyMap();

        val newAttrMap = JsonUtils.toMap(obj);

        val diffResult = diffAttrMap(oldAttrMap, newAttrMap);
        componentAttributeService?.batchUpdateAttr(ComponentAttributeConvertor.toUpdateDTOList(comId, diffResult["update"] ?: Collections.emptyMap()));
        componentAttributeService?.remoteByAttrs(comId, diffResult["remove"]?.keys?.toList() ?: Collections.emptyList());
        val lastAttrs = componentAttributeService?.batchCreate(ComponentAttributeConvertor.to(comId, diffResult["create"] ?: Collections.emptyMap()));

        return lastAttrs?.let {
            JsonUtils.parseMap(it)
        }
            ?: JsonUtils.createObject();
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