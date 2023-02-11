package dev.yidafu.pan.component.service

import dev.yidafu.pan.common.model.dto.SaveComponentDTO
import dev.yidafu.pan.common.model.dto.UpdateComponentDTO
import dev.yidafu.pan.common.model.vo.ComponentVO

interface ComponentService {
    fun findById(id: Long): ComponentVO
    fun findAllByScreenId(screenId: Long): List<ComponentVO>
    fun updateById(id: Long, dto: UpdateComponentDTO): ComponentVO

    /**
     * 创建组件
     */
    fun createOne(dto: SaveComponentDTO): ComponentVO

    /**
     * 根据 id 删除组件
     */
    fun removeById(id: Long): Boolean

    fun templateList(): List<ComponentVO>
}
