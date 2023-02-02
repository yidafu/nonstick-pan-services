package dev.yidafu.pan.frontend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class NonstickPanFrontendApplication

fun main(args: Array<String>) {
    runApplication<NonstickPanFrontendApplication>(*args)
}