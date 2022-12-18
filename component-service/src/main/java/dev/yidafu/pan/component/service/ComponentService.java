package dev.yidafu.pan.component.service;

import dev.yidafu.pan.component.domain.dto.SaveComponentDTO;
import dev.yidafu.pan.component.domain.dto.UpdateComponentDTO;
import dev.yidafu.pan.component.domain.vo.ComponentVO;

import java.util.List;

public interface ComponentService {
    ComponentVO findById(Long id);

    List<ComponentVO> findAllByScreenId(Long screenId);

    ComponentVO updateById(Long id, UpdateComponentDTO dto);

    ComponentVO createOne(SaveComponentDTO dto);
}
