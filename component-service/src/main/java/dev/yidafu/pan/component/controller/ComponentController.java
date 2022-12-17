package dev.yidafu.pan.component.controller;

import dev.yidafu.pan.component.domain.dto.SaveComponentDto;
import dev.yidafu.pan.component.domain.dto.UpdateComponentDto;
import dev.yidafu.pan.component.domain.vo.ComponentVo;
import dev.yidafu.pan.component.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComponentController {

    @Autowired
    ComponentService componentService;

    @GetMapping("/component/{id}")
    public ComponentVo findOne(@PathVariable Long id) {
        return componentService.findById(id);
    }

    @GetMapping("/components")
    public List<ComponentVo> listByScreen(@RequestParam("screenId") Long screenId) {
        return componentService.findAllByScreenId(screenId);
    }

    @PostMapping("/component")
    public  ComponentVo createOne(@RequestBody SaveComponentDto dto) {
        return componentService.createOne(dto);
    }

    @PutMapping("/component/{id}")
    public ComponentVo updatePartialOne(@PathVariable Long id, @RequestBody UpdateComponentDto dto) {
        return componentService.updateById(id, dto);
    }
}
