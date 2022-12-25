package dev.yidafu.pan.component.common.json

enum class JsonValueType(val value: Byte) {
    String(0), Number(1), Boolean(2)
}