package dev.yidafu.pan.component.service;

import dev.yidafu.pan.component.domain.dto.SaveComponentDto;
import dev.yidafu.pan.component.domain.dto.UpdateComponentDto;
import dev.yidafu.pan.component.domain.vo.ComponentVo;

import java.util.List;

public interface ComponentService {
    ComponentVo findById(Long id);

    List<ComponentVo> findAllByScreenId(Long screenId);

    ComponentVo updateById(Long id, UpdateComponentDto dto);

    ComponentVo createOne(SaveComponentDto dto);
}
