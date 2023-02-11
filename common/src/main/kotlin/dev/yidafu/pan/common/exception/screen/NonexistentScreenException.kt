package dev.yidafu.pan.common.exception.screen

import dev.yidafu.pan.common.exception.ExceptionCode
import dev.yidafu.pan.common.exception.ServiceException

class NonexistentScreenException : ServiceException(ExceptionCode.NonexistentScreen)
