package dev.yidafu.pan.screen.service.impl

import dev.yidafu.pan.common.exception.screen.CreateScreenFailException
import dev.yidafu.pan.common.model.vo.PageVO
import dev.yidafu.pan.common.model.vo.ScreenVO
import dev.yidafu.pan.screen.common.exception.NonexistentScreenException
import dev.yidafu.pan.screen.convertor.ScreenConvertor
import dev.yidafu.pan.screen.domain.dto.SaveScreenDTO
import dev.yidafu.pan.screen.domain.dto.UpdateScreenDTO
import dev.yidafu.pan.screen.domain.mapper.*
import dev.yidafu.pan.screen.domain.mapper.ScreenDynamicSqlSupport.screen
import dev.yidafu.pan.screen.domain.query.PaginationQuery
import dev.yidafu.pan.screen.service.ScreenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ScreenServiceImpl : ScreenService {

    @Autowired
    val mapper: ScreenMapper? = null

    @Autowired
    val convertor: ScreenConvertor? = null

    override fun createOne(dto: SaveScreenDTO): ScreenVO {
        val screen = convertor?.from(dto)

        return screen?.let {

            mapper?.insertSelective(it)
            screen.id?.let { it1 -> getOneById(it1) }
        } ?: throw CreateScreenFailException()
    }

    override fun getOneById(screenId: Long): ScreenVO {
        val screen = mapper?.selectOne {
            where {
                screen.id isEqualTo screenId
            }
        }
        return screen?.let { convertor?.to(it) } ?: throw NonexistentScreenException()
    }

    override fun updateScreen(dto: UpdateScreenDTO): ScreenVO {
        val screen = convertor?.from(dto)

        screen?.let {
            mapper?.updateByPrimaryKeySelective(screen)
        }

        return screen?.id?.let { getOneById(it) } ?: throw NonexistentScreenException()
    }

    override fun removeById(screenId: Long): Boolean {
        return mapper?.delete {
            where {
                screen.id isEqualTo screenId
            }
        }?.let { it > 0 } ?: false
    }

    override fun getAll(query: PaginationQuery): PageVO<List<ScreenVO>> {
        val screenList = mapper?.select {
            query.size?.let {
                val page = (query.page ?: 1)
                limit(page * it)
                offset(page - 1)
            }
        } ?: listOf()
        val total = mapper?.count { } ?: 0
        return PageVO(
            convertor?.to(screenList) ?: listOf(),
            query.page ?: 1,
            query.size ?: -1,
            total,
        )
    }
}
