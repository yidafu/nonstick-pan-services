package dev.yidafu.pan.component.service

import dev.yidafu.pan.common.model.dto.SaveComponentDTO
import dev.yidafu.pan.common.model.dto.UpdateComponentDTO
import dev.yidafu.pan.common.model.vo.ComponentVO

interface ComponentService {
    fun findById(id: Long): ComponentVO
    fun findAllByScreenId(screenId: Long): List<ComponentVO?>
    fun updateById(id: Long, dto: UpdateComponentDTO): ComponentVO
    fun createOne(dto: SaveComponentDTO): ComponentVO
}