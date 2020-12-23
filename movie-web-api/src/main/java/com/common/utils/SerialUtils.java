package com.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author TanHaooo
 * @date 2020/12/23 20:40
 */
public class SerialUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJSONString(Object object) throws JsonProcessingException {
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(object);
        return jsonString;
    }
}
