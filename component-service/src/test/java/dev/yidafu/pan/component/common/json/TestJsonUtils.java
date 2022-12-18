package dev.yidafu.pan.component.common.json;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("JsonUtils@parseMap")
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

    @Test
    @DisplayName("JsonUtils#toMap")
    public void testToMap() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        ObjectNode child = mapper.createObjectNode();
        child.put("child", "Foo");
        root.put("prop", child);
        ArrayNode array = mapper.createArrayNode();
        array.add(1);
        root.put("arr", array);

        Map<String, JsonValue> map = JsonUtils.toMap(root);
        JsonValue value1 = map.get("prop.child");
        Assertions.assertEquals(value1.getString(), "Foo");
        JsonValue value2 = map.get("arr[0]");

        Assertions.assertEquals(value2.getNumber(), 1);
    }
}
