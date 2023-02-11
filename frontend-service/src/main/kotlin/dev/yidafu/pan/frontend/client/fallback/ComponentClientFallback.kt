package dev.yidafu.pan.frontend.client.fallback

import dev.yidafu.pan.common.model.dto.UpdateComponentDTO
import dev.yidafu.pan.common.model.vo.ComponentVO
import dev.yidafu.pan.frontend.client.ComponentClient

class ComponentClientFallback : ComponentClient {
    override fun getComponents(screenId: Long): List<ComponentVO> {
        TODO("Not yet implemented")
    }

    override fun updateComponent(componentId: Long, updateDto: UpdateComponentDTO): ComponentVO {
        TODO("Not yet implemented")
    }
}
