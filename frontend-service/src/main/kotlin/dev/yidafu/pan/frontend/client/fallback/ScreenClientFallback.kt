package dev.yidafu.pan.frontend.client.fallback

import dev.yidafu.pan.common.model.vo.PageVO
import dev.yidafu.pan.common.model.vo.ScreenVO
import dev.yidafu.pan.frontend.client.ScreenClient

class ScreenClientFallback: ScreenClient {
    override fun getAll(): PageVO<List<ScreenVO>> {
        TODO("Not yet implemented")
    }

    override fun getList(page: Long, size: Long): PageVO<List<ScreenVO>> {
        TODO("Not yet implemented")
    }

    override fun getOneScreen(screenId: Long): ScreenVO {
        TODO("Not yet implemented")
    }
}