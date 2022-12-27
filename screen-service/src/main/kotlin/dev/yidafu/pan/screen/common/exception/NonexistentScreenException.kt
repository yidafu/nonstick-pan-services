package dev.yidafu.pan.screen.common.exception

import dev.yidafu.pan.common.exception.ExceptionCode
import dev.yidafu.pan.common.exception.ServiceException
//import dev.yidafu.pan.common.exception.ServiceException

class NonexistentScreenException : ServiceException(ExceptionCode.NonexistentScreen);