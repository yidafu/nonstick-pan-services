package dev.yidafu.pan.component.common.json;


import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.yidafu.pan.component.common.json.JsonValueType;
import dev.yidafu.pan.component.common.json.JsonValue;

@SpringBootTest
public class TestJsonUtils {

    @SneakyThrows
    @Test
    public void testParseMap() {
        Map<String, JsonValue> map = new HashMap<>();
        map.put("prop1", new JsonValue(JsonValueType.String, "Foo"));
        map.put("prop2.nest", new JsonValue(JsonValueType.Number, "1234"));
        map.put("prop3[0]", new JsonValue(JsonValueType.Boolean, "false"));

        ObjectNode node = JsonUtils.parseMap(map);
        Assertions.assertEquals("Foo", node.get("prop1").textValue());
        Assertions.assertEquals(1234L, node.get("prop2").get("nest").longValue());
        Assertions.assertEquals(false, node.get("prop3").get(0).booleanValue());
    }
}
