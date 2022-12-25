package dev.yidafu.pan.component.common.exception.component

import dev.yidafu.pan.component.common.exception.ExpectionCode
import dev.yidafu.pan.component.common.exception.ServiceException

class ComponentCreateFailException: ServiceException(ExpectionCode.ComponentCreateFail)