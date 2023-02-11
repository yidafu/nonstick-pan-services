package dev.yidafu.pan.common.exception.json

import dev.yidafu.pan.common.exception.ExceptionCode
import dev.yidafu.pan.common.exception.ServiceException

class UnknownJsonValueTypeException : ServiceException(ExceptionCode.UnknownJsonValueType)
