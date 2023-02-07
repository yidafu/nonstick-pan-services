package dev.yidafu.pan.common.json

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import dev.yidafu.pan.common.exception.json.UnknownJsonValueTypeException
import org.slf4j.LoggerFactory

object JsonUtils {
    private val logger = LoggerFactory.getLogger(JsonUtils::class.java)
    private val objectMapper = ObjectMapper()

    fun createObject(): ObjectNode {
        return objectMapper.createObjectNode();
    }

    fun createArray(): ArrayNode {
        return objectMapper.createArrayNode();
    }
    @Throws(JsonProcessingException::class)
    fun object2String(node: ObjectNode?): String {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node)
    }

    fun parseMap(map: Map<String, JsonValue>): ObjectNode {
        val root = objectMapper.createObjectNode()
        map.forEach { (prop: String, value: JsonValue) -> setPropertyValue(root, prop2PathList(prop), value) }
        return root
    }

    @JvmStatic
    fun toMap(root: ObjectNode): Map<String, JsonValue> {
        val map: MutableMap<String, JsonValue> = HashMap()
        tree2Map(root, "", map)
        return map
    }

    private fun <T : JsonNode?> setPropertyValue(node: T, paths: List<String>, value: JsonValue) {
        if (paths.size == 1) {
            if (node!!.isObject) {
                if (value.isNumber) {
                    (node as ObjectNode).put(paths[0], value.getNumber())
                } else if (value.isBoolean) {
                    (node as ObjectNode).put(paths[0], value.getBoolean())
                } else if (value.isString) {
                    (node as ObjectNode).put(paths[0], value.getString())
                } else {
                    throw UnknownJsonValueTypeException()
                }
            } else {
                val path = paths[0]
                val index = path.substring(1, path.length - 1).toInt()
                if (value.isNumber) {
                    (node as ArrayNode).remove(index)
                    (node as ArrayNode).add(value.getNumber())
                } else if (value.isBoolean) {
                    (node as ArrayNode).remove(index)
                    (node as ArrayNode).add(value.getBoolean())
                } else if (value.isString) {
                    (node as ArrayNode).remove(index)
                    (node as ArrayNode).add(value.getString())
                } else {
                    throw UnknownJsonValueTypeException()
                }
            }
            return
        }
        val path = paths[0]
        val subPaths = paths.subList(1, paths.size)
        if (path.startsWith("[")) {
            val index = path.substring(1, path.length - 1).toInt()
            if (node!!.has(index)) {
                val childNode = node[index]
                setPropertyValue(childNode, subPaths, value)
            } else {
                val childNode = if (subPaths[0].startsWith(("["))) {
                    objectMapper.createArrayNode();
                } else {
                    objectMapper.createObjectNode();
                }
                (node as ArrayNode).insert(index, childNode)
                setPropertyValue(childNode, subPaths, value)
            }
        } else {
            if (node!!.has(path)) {
                val childNode = node[path]
                setPropertyValue(childNode, subPaths, value)
            } else {
                val childNode =  if (subPaths[0].startsWith("[")) {
                    objectMapper.createArrayNode()
                } else {
                    objectMapper.createObjectNode()
                }

                (node as ObjectNode).replace(path, childNode)
                setPropertyValue(childNode, subPaths, value)
            }
        }
    }

    private fun prop2PathList(prop: String): List<String> {
        var mutProp = prop
        val paths: MutableList<String> = ArrayList()
        while (mutProp.isNotEmpty()) {
            if (mutProp[0] == '[') {
                val closeBracketIdx = mutProp.indexOf(']')
                val path = mutProp.substring(0, closeBracketIdx + 1)
                paths.add(path)
                mutProp = mutProp.substring(closeBracketIdx + 1)
                if (mutProp.isNotEmpty() && mutProp[0] == '.') {
                    mutProp = mutProp.substring(1)
                }
                continue
            }

            val dotIdx = mutProp.indexOf('.')
            val bracketIdx = mutProp.indexOf('[')
            if (dotIdx < 0 && bracketIdx < 0) {
                paths.add(mutProp)
                break
            }
            val idx = if (dotIdx < 0) {
                bracketIdx
            } else if (bracketIdx < 0) {
                dotIdx
            } else {
                dotIdx.coerceAtMost(bracketIdx)
            }
            if (idx >= 0) {
                val path = mutProp.substring(0, idx)
                paths.add(path)
                mutProp = if (mutProp[idx] == '.') {
                    mutProp.substring(idx + 1)
                } else {
                    mutProp.substring(idx)
                }
            }
        }
        return paths
    }

    private fun <T : JsonNode?> tree2Map(node: T, prop: String, map: MutableMap<String, JsonValue>) {
        if (node == null) {
            return
        }
        if (node.isObject) {
            val entries = node.fields()
            while (entries.hasNext()) {
                val (key, value) = entries.next()
                tree2Map(value, "$prop.$key", map)
            }
        } else if (node.isArray) {
            val it: Iterator<JsonNode> = node.iterator()
            var index = 0
            while (it.hasNext()) {
                val childNode = it.next()
                tree2Map(childNode, "$prop[$index]", map)
                index++
            }
        } else if (node.isValueNode) {
            val propWithoutDot = prop.substring(1)
            map[propWithoutDot] = when {
                node.isNumber ->  JsonValue.Companion.createNumber(node.doubleValue())
                node.isBoolean -> JsonValue.Companion.createBoolean(node.booleanValue())
                node.isTextual -> JsonValue.Companion.createString(node.textValue())
                else -> JsonValue.Companion.createString("")
            }
        }
    }
}