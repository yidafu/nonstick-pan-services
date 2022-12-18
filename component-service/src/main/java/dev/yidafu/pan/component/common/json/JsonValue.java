package dev.yidafu.pan.component.common.json;

import dev.yidafu.pan.component.common.exception.UnknownJsonValueTypeException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class JsonValue {
    JsonValueType valueType;

    String value;

    public JsonValue(byte valueType, String value) {
        if( valueType == JsonValueType.String.ordinal()) {
            this.valueType = JsonValueType.String;
        } else if (valueType == JsonValueType.Number.ordinal()) {
            this.valueType = JsonValueType.Number;
        } else if (valueType == JsonValueType.Boolean.ordinal()) {
            this.valueType = JsonValueType.Boolean;
        } else {
            throw new UnknownJsonValueTypeException();
        }
        this.value = value;
    }

    public static JsonValue createString(String value) {
        return new JsonValue(JsonValueType.String, value);
    }


    public static JsonValue createNumber(Long value) {
        return new JsonValue(JsonValueType.Number, String.valueOf(value));
    }

    public static JsonValue createBoolean(Boolean value) {
        return new JsonValue(JsonValueType.Boolean, String.valueOf(value));
    }

    Boolean isString() {
        return valueType == JsonValueType.String;
    }

    Boolean isNumber() {
        return valueType == JsonValueType.Number;
    }

    Boolean isBoolean() {
        return valueType == JsonValueType.Boolean;
    }

    String getString() {
        return getValue();
    }

    Long getNumber() {
        return Long.parseLong(getValue());
    }

    Boolean getBoolean() {
        return Boolean.parseBoolean(getValue());
    }

    public String getValue() {
        return value;
    }
}
