package dev.yidafu.pan.component.service

import dev.yidafu.pan.common.json.JsonValue
import dev.yidafu.pan.common.model.dto.SaveComponentAttributeDTO
import dev.yidafu.pan.common.model.dto.UpdateComponentAttributeDTO
import dev.yidafu.pan.component.domain.model.ComponentAttribute

interface ComponentAttributeService {
    fun findOneById(id: Long): ComponentAttribute
    fun findOneByAttr(attr: String): ComponentAttribute
    fun findAllByOwner(ownerId: Long): Map<String, JsonValue>

    fun findAllByOwnerList(ownerIdList: List<Long>): Map<Long, Map<String, JsonValue>>
    fun createOne(dto: SaveComponentAttributeDTO): ComponentAttribute
    fun batchCreate(list: List<SaveComponentAttributeDTO>): Map<String, JsonValue>
    fun updateByAttr(dto: UpdateComponentAttributeDTO): ComponentAttribute
    fun updateById(id: Long, value: String): ComponentAttribute
    fun batchUpdateAttr(list: List<UpdateComponentAttributeDTO>): List<ComponentAttribute>
    fun remoteByAttr(ownerId: Long, attr: String): Boolean
    fun remoteByAttrs(ownerId: Long, attrList: List<String>): Boolean
    fun remoteById(id: Long): Boolean
}
