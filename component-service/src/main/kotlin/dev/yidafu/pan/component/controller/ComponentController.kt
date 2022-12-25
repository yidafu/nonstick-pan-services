package dev.yidafu.pan.component.controller

import dev.yidafu.pan.component.domain.dto.SaveComponentDTO
import dev.yidafu.pan.component.domain.dto.UpdateComponentDTO
import dev.yidafu.pan.component.domain.vo.ComponentVO
import dev.yidafu.pan.component.service.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ComponentController {
    @Autowired
    var componentService: ComponentService? = null
    @GetMapping("/component/{id}")
    fun findOne(@PathVariable id: Long?): ComponentVO? {
        return id?.let {
            componentService!!.findById(id)
        }
    }

    @GetMapping("/components")
    fun listByScreen(@RequestParam("screenId") screenId: Long?): List<ComponentVO?>? {
        if (null == screenId) {
            throw IllegalArgumentException("Query 'screenId' must not be null")
        }
        return componentService!!.findAllByScreenId(screenId);
    }

    @PostMapping("/component")
    fun createOne(@RequestBody dto: SaveComponentDTO?): ComponentVO? {
        if (null == dto) {
            throw IllegalArgumentException("Create Component data must not be Null")
        }
        return componentService!!.createOne(dto)
    }

    @PutMapping("/component/{id}")
    fun updatePartialOne(@PathVariable id: Long?, @RequestBody dto: UpdateComponentDTO?): ComponentVO? {
        if (null == id) {
            throw  IllegalArgumentException("Update Component need component id")
        }
        if (null == dto) {
            throw  IllegalArgumentException("Update Component must not be null")
        }
        return   componentService!!.updateById(id, dto)
    }
}