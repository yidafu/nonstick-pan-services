package dev.yidafu.pan.component.convertor;

import dev.yidafu.pan.component.domain.dto.SaveComponentDto;
import dev.yidafu.pan.component.domain.dto.UpdateComponentDto;
import dev.yidafu.pan.component.domain.entity.Component;
import dev.yidafu.pan.component.domain.vo.ComponentVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComponentConvertor {
    ComponentConvertor INSTANCE = Mappers.getMapper(ComponentConvertor.class);

    List<ComponentVo> to(List<Component> list);

    ComponentVo to(Component com);

    Component from(SaveComponentDto dto);

    Component from(UpdateComponentDto dto);
}
