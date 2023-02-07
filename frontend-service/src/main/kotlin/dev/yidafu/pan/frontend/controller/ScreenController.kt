package dev.yidafu.pan.frontend.controller

import dev.yidafu.kotlin.api.common.Response
import dev.yidafu.pan.common.exception.ScreenNoComponentException
import dev.yidafu.pan.common.model.dto.UpdateComponentDTO
import dev.yidafu.pan.common.model.vo.ComponentVO
import dev.yidafu.pan.common.model.vo.PageVO
import dev.yidafu.pan.common.model.vo.ScreenVO
import dev.yidafu.pan.frontend.client.ComponentClient
import dev.yidafu.pan.frontend.client.ScreenClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * TODO: 鉴权
 */
@RestController
class ScreenController {
    @Autowired
    var screenClient: ScreenClient? = null;

    @Autowired
    lateinit var componentClient: ComponentClient;

    @GetMapping("/screens")
    fun getAllScreen(): Response<List<ScreenVO>> {
        return screenClient?.getAll()?.let {
            Response.success(it.data)
        } ?: Response.success(listOf())
    }

    @GetMapping("/screens/page")
    fun getPaginationScreen(
        @RequestParam(value = "page", defaultValue = "1") page: Long,
        @RequestParam(value = "size", defaultValue = "10") size: Long
    ): Response<PageVO<List<ScreenVO>>> {
        return screenClient?.getList(page, size)?.let {
            Response.success(it)
        } ?: Response.success(PageVO(listOf(), page, size, 0))
    }

    @GetMapping("/screen/{screenId}")
    fun getOneScreen(@PathVariable("screenId") screenId: Long): Response<ScreenVO> {
        return screenClient?.getOneScreen(screenId)?.let {
            Response.success(it)
        } ?: Response.success(ScreenVO())
    }

    @GetMapping("/screen/{screenId}/components")
    fun getScreenComponent(@PathVariable("screenId") screenId: Long): Response<List<ComponentVO>> {
        return componentClient.getComponents(screenId).let {
            Response.success(it)
        } ?: Response.success(listOf())
    }

    @PutMapping("/screen/{screenId}/component/{componentId}")
    fun updateComponent(
        @PathVariable("screenId") screenId: Long,
        @PathVariable("componentId") componentId: Long,
        @RequestBody updateDto: UpdateComponentDTO,
    ): Response<ComponentVO> {
        return componentClient.updateComponent(componentId, updateDto).let {
            if (it.screenId != screenId) {
                throw ScreenNoComponentException()
            }
            Response.success(it)
        }
    }
}