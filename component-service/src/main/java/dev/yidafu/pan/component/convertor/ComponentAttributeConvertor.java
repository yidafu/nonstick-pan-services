package dev.yidafu.pan.component.convertor;

import com.fasterxml.jackson.databind.util.JSONPObject;
import dev.yidafu.pan.component.domain.dto.SaveComponentAttributeDTO;
import dev.yidafu.pan.component.domain.entity.ComponentAttribute;
import org.mapstruct.Mapper;

import java.util.List;



@Mapper(componentModel = "spring")
public interface ComponentAttributeConvertor {

    List<ComponentAttribute> from(List<SaveComponentAttributeDTO> list);

    ComponentAttribute from(SaveComponentAttributeDTO list);
}
