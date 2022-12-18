package dev.yidafu.pan.component.controller;

import dev.yidafu.pan.component.domain.dto.SaveComponentDTO;
import dev.yidafu.pan.component.domain.dto.UpdateComponentDTO;
import dev.yidafu.pan.component.domain.vo.ComponentVO;
import dev.yidafu.pan.component.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComponentController {

    @Autowired
    ComponentService componentService;

    @GetMapping("/component/{id}")
    public ComponentVO findOne(@PathVariable Long id) {
        return componentService.findById(id);
    }

    @GetMapping("/components")
    public List<ComponentVO> listByScreen(@RequestParam("screenId") Long screenId) {
        return componentService.findAllByScreenId(screenId);
    }

    @PostMapping("/component")
    public ComponentVO createOne(@RequestBody SaveComponentDTO dto) {
        return componentService.createOne(dto);
    }

    @PutMapping("/component/{id}")
    public ComponentVO updatePartialOne(@PathVariable Long id, @RequestBody UpdateComponentDTO dto) {
        return componentService.updateById(id, dto);
    }
}
