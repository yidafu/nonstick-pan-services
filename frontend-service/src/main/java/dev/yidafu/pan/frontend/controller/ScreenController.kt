package dev.yidafu.pan.frontend.controller

import dev.yidafu.kotlin.api.common.Response
import dev.yidafu.pan.common.model.vo.PageVO
import dev.yidafu.pan.common.model.vo.ScreenVO
import dev.yidafu.pan.frontend.client.ScreenClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ScreenController {
    @Autowired
    val screenClient: ScreenClient? = null;

    @GetMapping("/api/screens")
    fun getAllScreen(): Response<List<ScreenVO>> {
        return screenClient?.getAll()?.let {
            Response.success(it.data)
        } ?: Response.success(listOf())
    }

    @GetMapping("/api/screens/page")
    fun getPaginationScreen(
        @RequestParam(value = "page", defaultValue = "1") page: Long,
        @RequestParam(value = "size", defaultValue = "10") size: Long
    ): Response<PageVO<List<ScreenVO>>> {
        return screenClient?.getList(page, size)?.let {
            Response.success(it)
        } ?: Response.success(PageVO(listOf(), page, size, 0))
    }
}