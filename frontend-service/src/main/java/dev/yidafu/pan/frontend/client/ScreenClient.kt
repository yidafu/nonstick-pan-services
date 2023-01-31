package dev.yidafu.pan.frontend.client


import dev.yidafu.pan.common.model.vo.PageVO
import dev.yidafu.pan.common.model.vo.ScreenVO
import dev.yidafu.pan.frontend.client.fallback.ScreenClientFallback
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "PanScreenService", fallback = ScreenClientFallback::class)
interface ScreenClient {
    @GetMapping("/screens")
    fun getAll(): PageVO<List<ScreenVO>>

    @GetMapping("/screens")
    fun getList(@RequestParam("page") page: Long, @RequestParam("size") size: Long): PageVO<List<ScreenVO>>
}