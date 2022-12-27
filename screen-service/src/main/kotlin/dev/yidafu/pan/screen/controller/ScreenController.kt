package dev.yidafu.pan.screen.controller

import dev.yidafu.pan.screen.domain.dto.SaveScreenDTO
import dev.yidafu.pan.screen.domain.dto.UpdateScreenDTO
import dev.yidafu.pan.screen.domain.vo.ScreenVO
import dev.yidafu.pan.screen.service.ScreenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ScreenController {

    @Autowired
    var screenService: ScreenService? = null;


    @GetMapping("/screen/{screenId}")
    fun getScreenById(@PathVariable("screenId") screenId: Long): ScreenVO {
        return screenService!!.getOneById(screenId)
    }


    @PutMapping("/screen/{screenId}")
    fun updateScreenById(@PathVariable("screenId") screenId: Long, @RequestBody updateDto: UpdateScreenDTO): ScreenVO {
        updateDto.id = screenId;
        return screenService!!.updateScreen(updateDto)
    }

    @DeleteMapping("/screen/{screenId}")
    fun removeScreenById(@PathVariable("screenId") screenId: Long): Boolean {
        return screenService!!.removeById(screenId);
    }



    @PostMapping("/screen")
    fun createScreen(@RequestBody saveDto: SaveScreenDTO): ScreenVO {
        return screenService!!.createOne(saveDto)
    }
}