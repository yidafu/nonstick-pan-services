package dev.yidafu.pan.common.exception.component

import dev.yidafu.pan.common.exception.ExceptionCode
import dev.yidafu.pan.common.exception.ServiceException

class ComponentCreateFailException: ServiceException(ExceptionCode.ComponentCreateFail)