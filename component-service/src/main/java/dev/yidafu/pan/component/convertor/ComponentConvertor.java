package dev.yidafu.pan.component.convertor;

import dev.yidafu.pan.component.domain.dto.SaveComponentDTO;
import dev.yidafu.pan.component.domain.dto.UpdateComponentDTO;
import dev.yidafu.pan.component.domain.entity.Component;
import dev.yidafu.pan.component.domain.vo.ComponentVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComponentConvertor {
    ComponentConvertor INSTANCE = Mappers.getMapper(ComponentConvertor.class);

    List<ComponentVO> to(List<Component> list);

    ComponentVO to(Component com);

    Component from(SaveComponentDTO dto);

    Component from(UpdateComponentDTO dto);
}
