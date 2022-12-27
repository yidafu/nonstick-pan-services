package dev.yidafu.pan.component.common.exception


open class ServiceException : RuntimeException {
    var code: Int
    override var message: String?

    constructor(message: String?) : super(message) {
        this.message = message
        code = 9999
    }

    constructor(code: Int, message: String?) : super(message) {
        this.message = message
        this.code = code
    }

    constructor(code: ExpectionCode) : super(code.message) {
        this.code = code.code
        message = code.message
    }
}