package dev.yidafu.pan.component.common.json;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class JsonValue {
    JsonValueType valueType;

    String value;

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
