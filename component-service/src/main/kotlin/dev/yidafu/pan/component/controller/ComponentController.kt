//package dev.yidafu.pan.component.controller
//
//import dev.yidafu.pan.component.domain.dto.SaveComponentDTO
//import dev.yidafu.pan.component.domain.dto.UpdateComponentDTO
//import dev.yidafu.pan.component.domain.vo.ComponentVO
//import dev.yidafu.pan.component.service.ComponentService
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.web.bind.annotation.*
//
////@RestController
//class ComponentController {
////    @Autowired
////    var componentService: ComponentService? = null
////    @GetMapping("/component/{id}")
////    fun findOne(@PathVariable id: Long?): ComponentVO? {
////        return componentService!!.findById(id)
////    }
////
////    @GetMapping("/components")
////    fun listByScreen(@RequestParam("screenId") screenId: Long?): List<ComponentVO?>? {
////        return componentService!!.findAllByScreenId(screenId)
////    }
////
////    @PostMapping("/component")
////    fun createOne(@RequestBody dto: SaveComponentDTO?): ComponentVO? {
////        return componentService!!.createOne(dto)
////    }
////
////    @PutMapping("/component/{id}")
////    fun updatePartialOne(@PathVariable id: Long?, @RequestBody dto: UpdateComponentDTO?): ComponentVO? {
////        return componentService!!.updateById(id, dto)
////    }
//}