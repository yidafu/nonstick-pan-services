package dev.yidafu.pan.component.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EchoController {
    @Operation(summary = "Echo 接口", description = "测试接口")
    @GetMapping(value = ["/echo"])
    fun echo(): String {
        return "Hello, Pan"
    }
}
