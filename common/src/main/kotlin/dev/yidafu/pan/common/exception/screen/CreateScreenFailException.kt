package dev.yidafu.pan.common.exception.screen

import dev.yidafu.kotlin.api.common.ServiceException
import dev.yidafu.pan.common.exception.ExceptionCode

class CreateScreenFailException: ServiceException(ExceptionCode.CreateScreenFail)