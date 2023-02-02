package dev.yidafu.pan.frontend.client

import dev.yidafu.pan.common.model.vo.ComponentVO
import dev.yidafu.pan.frontend.client.fallback.ComponentClientFallback
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam


@FeignClient("PanComponentService", fallback = ComponentClientFallback::class)
interface ComponentClient {
    @GetMapping("/components")
    fun getComponents(@RequestParam("screenId") screenId: Long): List<ComponentVO>
}