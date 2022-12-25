package dev.yidafu.pan.component.common.exception.attribute

import dev.yidafu.pan.component.common.exception.ExpectionCode
import dev.yidafu.pan.component.common.exception.ServiceException

class IllegalComponentAttributeOwnerException : ServiceException(ExpectionCode.IllegalComponentAttributeOwner)