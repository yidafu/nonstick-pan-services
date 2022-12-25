package dev.yidafu.pan.component.service

import dev.yidafu.pan.component.domain.dto.SaveComponentAttributeDTO
import dev.yidafu.pan.component.domain.dto.UpdateComponentAttributeDTO
import dev.yidafu.pan.component.domain.model.ComponentAttribute

interface ComponentAttributeService {
    fun findOneById(id: Long): ComponentAttribute
    fun findOneByAttr(attr: String): ComponentAttribute
    fun findAllByOwner(ownerId: Long): List<ComponentAttribute>
    fun createOne(dto: SaveComponentAttributeDTO): ComponentAttribute
    fun batchCreate(list: List<SaveComponentAttributeDTO>): List<ComponentAttribute>
    fun updateByAttr(attr: String, value: String): ComponentAttribute
    fun updateById(id: Long, value: String): ComponentAttribute
    fun batchUpdateAttr(list: List<UpdateComponentAttributeDTO>): List<ComponentAttribute>
    fun remoteByAttr(ownerId: Long, attr: String): Boolean
    fun remoteByAttrs(ownerId: Long, attrList: List<String>): Boolean
    fun remoteById(id: Long): Boolean
}