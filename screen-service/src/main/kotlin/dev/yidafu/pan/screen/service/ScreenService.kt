package dev.yidafu.pan.screen.service

import dev.yidafu.pan.common.model.vo.PageVO
import dev.yidafu.pan.common.model.vo.ScreenVO
import dev.yidafu.pan.screen.domain.dto.SaveScreenDTO
import dev.yidafu.pan.screen.domain.dto.UpdateScreenDTO
import dev.yidafu.pan.screen.domain.query.PaginationQuery

interface ScreenService {
    fun createOne(dto: SaveScreenDTO): ScreenVO

    fun getOneById(screenId: Long): ScreenVO

    fun updateScreen(dto: UpdateScreenDTO): ScreenVO

    fun removeById(screenId: Long): Boolean

    fun getAll(query: PaginationQuery): PageVO<List<ScreenVO>>
}
