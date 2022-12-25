package dev.yidafu.pan.component.service.impl

import dev.yidafu.pan.component.common.exception.component.ComponentCreateFailException
import dev.yidafu.pan.component.common.exception.component.NonexistentComponentException
import dev.yidafu.pan.component.convertor.ComponentConvertor
import dev.yidafu.pan.component.domain.dto.SaveComponentDTO
import dev.yidafu.pan.component.domain.dto.UpdateComponentDTO
import dev.yidafu.pan.component.domain.mapper.ComponentDynamicSqlSupport.component
import dev.yidafu.pan.component.domain.mapper.ComponentMapper
import dev.yidafu.pan.component.domain.mapper.*
import dev.yidafu.pan.component.domain.model.Component
import dev.yidafu.pan.component.domain.vo.ComponentVO
import dev.yidafu.pan.component.service.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ComponentServiceImpl : ComponentService {
    @Autowired
    var mapper: ComponentMapper? = null

    @Autowired
    var convertor: ComponentConvertor? = null
    override fun findById(id: Long): ComponentVO {

        val component = mapper?.selectOne{
            where {
                component.id isEqualTo id
            }
        }
        return  component?.let {
            convertor?.to(it)
        } ?: throw NonexistentComponentException()

    }

    override fun findAllByScreenId(screenId: Long): List<ComponentVO?> {

        val componentList = mapper?.select {
            where {
                component.screenId isEqualTo screenId
            }
        }

        return componentList?.let { convertor?.to(componentList) } ?: Collections.emptyList()
    }

    override fun updateById(id: Long, dto: UpdateComponentDTO): ComponentVO {
        val component: Component = convertor!!.from(dto)

        component.id = id
        mapper?.updateByPrimaryKey(component)
        return findById(id)
    }

    override fun createOne(dto: SaveComponentDTO): ComponentVO {
        val component: Component = convertor!!.from(dto)
        mapper?.insert(component)
        return component.id?.let {
            findById(it)
        } ?: throw ComponentCreateFailException()
    }
}