package dev.yidafu.pan.screen.convertor

import dev.yidafu.pan.common.model.vo.ScreenVO
import dev.yidafu.pan.screen.domain.dto.SaveScreenDTO
import dev.yidafu.pan.screen.domain.dto.UpdateScreenDTO
import dev.yidafu.pan.screen.domain.model.Screen
import org.mapstruct.Mapper

@Mapper
interface ScreenConvertor {
    fun to(screen: Screen): ScreenVO

    fun to(list: List<Screen>): List<ScreenVO>

    fun from(dto: SaveScreenDTO): Screen

    fun from(dto: UpdateScreenDTO): Screen
}
