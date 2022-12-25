package dev.yidafu.pan.component.common.exception.json

import dev.yidafu.pan.component.common.exception.ExpectionCode
import dev.yidafu.pan.component.common.exception.ServiceException

class UnknownJsonValueTypeException : ServiceException(ExpectionCode.UnknownJsonValueType)