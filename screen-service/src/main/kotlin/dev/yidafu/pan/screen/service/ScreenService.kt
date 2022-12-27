package dev.yidafu.pan.screen.service

import dev.yidafu.pan.screen.domain.dto.SaveScreenDTO
import dev.yidafu.pan.screen.domain.dto.UpdateScreenDTO
import dev.yidafu.pan.screen.domain.vo.ScreenVO

interface ScreenService {
    fun createOne(dto: SaveScreenDTO): ScreenVO;

    fun getOneById(screenId: Long): ScreenVO;


    fun updateScreen(dto: UpdateScreenDTO): ScreenVO

    fun removeById(screenId: Long): Boolean
}