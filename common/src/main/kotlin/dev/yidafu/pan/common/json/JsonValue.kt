package dev.yidafu.pan.common.json

import dev.yidafu.pan.common.exception.json.UnknownJsonValueTypeException

class JsonValue(valueType: Byte?, value: String?) {
    var valueType: JsonValueType? = null
    var value: String

    init {
        if (valueType?.toInt() == JsonValueType.String.ordinal) {
            this.valueType = JsonValueType.String
        } else if (valueType?.toInt() == JsonValueType.Number.ordinal) {
            this.valueType = JsonValueType.Number
        } else if (valueType?.toInt() == JsonValueType.Boolean.ordinal) {
            this.valueType = JsonValueType.Boolean
        } else {
            throw UnknownJsonValueTypeException()
        }
        if (null == value) {
            this.valueType = JsonValueType.Null
            this.value = "null"
        } else {
            this.value = value
        }
    }

    val isString: Boolean
        get() = valueType == JsonValueType.String
    val isNumber: Boolean
        get() = valueType == JsonValueType.Number
    val isBoolean: Boolean
        get() = valueType == JsonValueType.Boolean

    fun getString(): String {
        return value
    }

    fun getNumber(): Double {
        return value.toDouble()
    }

    fun getBoolean(): Boolean {
        return java.lang.Boolean.parseBoolean(value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other is JsonValue) {
            return valueType == other.valueType && value == other.value
        }
        return false
    }

    override fun hashCode(): Int {
        var result = valueType?.hashCode() ?: 0
        result = 31 * result + value.hashCode()
        return result
    }

    companion object {
        fun createString(value: String): JsonValue {
            return JsonValue(JsonValueType.String.value, value)
        }

        fun createNumber(value: Double): JsonValue {
            return JsonValue(JsonValueType.Number.value, value.toString())
        }

        fun createBoolean(value: Boolean): JsonValue {
            return JsonValue(JsonValueType.Boolean.value, value.toString())
        }
    }
}
