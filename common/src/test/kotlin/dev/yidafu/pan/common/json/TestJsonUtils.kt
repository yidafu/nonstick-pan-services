package dev.yidafu.pan.common.json

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TestJsonUtils {
    @Test
    @DisplayName("JsonUtils@parseMap")
    fun testParseMap() {
        val map: MutableMap<String, JsonValue> = HashMap()
        map["prop1"] = JsonValue(JsonValueType.String.value, "Foo")
        map["prop2.nest"] = JsonValue(JsonValueType.Number.value, "1234")
        map["prop3[0]"] = JsonValue(JsonValueType.Boolean.value, "false")
        map["prop4[0].nest"] = JsonValue(JsonValueType.Boolean.value, "true")
        map["prop5[0]"] = JsonValue(JsonValueType.String.value, "str")
        val node: ObjectNode = JsonUtils.parseMap(map)
        Assertions.assertEquals("Foo", node.get("prop1").textValue())
        Assertions.assertEquals(1234L, node.get("prop2").get("nest").longValue())
        Assertions.assertEquals(false, node.get("prop3").get(0).booleanValue())
        Assertions.assertEquals(true, node.get("prop4").get(0).get("nest").booleanValue())
        Assertions.assertEquals("str", node.get("prop5").get(0).textValue())
    }

    @Test
    @DisplayName("JsonUtils#toMap")
    fun testToMap() {
        val mapper = ObjectMapper()
        val root: ObjectNode = mapper.createObjectNode()
        val child: ObjectNode = mapper.createObjectNode()
        child.put("child", "Foo")
        root.put("prop", child)
        val array: ArrayNode = mapper.createArrayNode()
        array.add(1)
        root.put("arr", array)
        val map = JsonUtils.toMap(root)
        val value1 = map["prop.child"]
        Assertions.assertEquals(value1!!.getString(), "Foo")
        val value2 = map["arr[0]"]
        Assertions.assertEquals(value2!!.getNumber(), 1)
    }

}