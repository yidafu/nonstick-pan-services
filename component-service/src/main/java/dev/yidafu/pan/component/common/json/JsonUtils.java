package dev.yidafu.pan.component.common.json;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.yidafu.pan.component.common.exception.UnknownJsonValueTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class JsonUtils {
    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String object2String(ObjectNode node) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
    }

    public static ObjectNode parseMap(Map<String, JsonValue> map) {

        ObjectNode root = objectMapper.createObjectNode();
        map.forEach((String prop, JsonValue value) -> setPropertyValue(root, prop2PathList(prop), value));

        return root;
    }

    private static <T extends JsonNode> void setPropertyValue(T node, List<String> paths, JsonValue value) {
        if (paths.size() == 1) {

            if (node.isObject()) {
                if (value.isNumber()) {
                    ((ObjectNode) node).put(paths.get(0), value.getNumber());
                } else if (value.isBoolean()) {
                    ((ObjectNode) node).put(paths.get(0), value.getBoolean());
                } else if (value.isString()){
                    ((ObjectNode) node).put(paths.get(0), value.getString());
                } else {
                    throw new UnknownJsonValueTypeException();
                }
            } else {
                String path = paths.get(0);
                int index = Integer.parseInt(path.substring(1, path.length() - 1));
                if (value.isNumber()) {
                    ((ArrayNode) node).remove(index);
                    ((ArrayNode) node).add(value.getNumber());
                } else if (value.isBoolean()) {
                    ((ArrayNode) node).remove(index);
                    ((ArrayNode) node).add(value.getBoolean());
                } else if (value.isString()) {
                    ((ArrayNode) node).remove(index);
                    ((ArrayNode) node).add(value.getBoolean());
                } else {
                    throw new UnknownJsonValueTypeException();
                }
            }
            return;
        }
        String path = paths.get(0);
        List<String> subPaths =  paths.subList(1, paths.size());
        if (path.startsWith("[")) {
            int index = Integer.parseInt(path.substring(1, path.length() - 1));
            if (node.has(index)) {
                ArrayNode childNode = (ArrayNode)node.get(index);
                setPropertyValue(childNode, subPaths, value);
            } else {
                ArrayNode childNode = objectMapper.createArrayNode();
                childNode.add(childNode);
                setPropertyValue(childNode, subPaths, value);
            }
        } else {
            if (node.has(path)) {
                JsonNode childNode = node.get(path);
                setPropertyValue(childNode, subPaths, value);
            } else {
                if (subPaths.get(0).startsWith("[")) {
                    ArrayNode childNode = objectMapper.createArrayNode();
                    ((ObjectNode) node).put(path, childNode);
                    setPropertyValue(childNode, subPaths, value);
                } else {
                    ObjectNode childNode = objectMapper.createObjectNode();
                    ((ObjectNode) node).put(path, childNode);
                    setPropertyValue(childNode, subPaths, value);
                }
            }
        }
    }

    private static List<String> prop2PathList(String prop) {
        List<String> paths = new ArrayList<>();

        while (prop.length() > 0) {
            if (prop.charAt(0) == '[') {
                int closeBracketIdx = prop.indexOf(']');
                String path = prop.substring(0, closeBracketIdx + 1);
                paths.add(path);
                prop = prop.substring(closeBracketIdx + 1);
                continue;
            }
            int dotIdx = prop.indexOf('.');
            int bracketIdx = prop.indexOf('[');
            if (dotIdx < 0 && bracketIdx < 0) {
                paths.add(prop);
                break;
            }

            int idx = -1;
            if (dotIdx < 0) {
                idx = bracketIdx;
            } else if (bracketIdx < 0) {
                idx = dotIdx;
            } else {
                Math.min(dotIdx, bracketIdx);
            }

            if (idx > 0) {
                String path = prop.substring(0, idx);
                paths.add(path);
                if ( prop.charAt(idx) == '.')  {
                    prop = prop.substring(idx + 1);
                } else {
                    prop = prop.substring(idx );
                }
            }
        }

        return  paths;
    }
}
