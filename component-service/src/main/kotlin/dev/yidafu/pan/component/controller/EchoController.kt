package dev.yidafu.pan.component.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EchoController {
    @GetMapping(value = ["/echo"])
    fun echo(): String {
        return "Hello, Pan"
    }
}