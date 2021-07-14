package maa.back.person.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonConverter {
    public static String asJsonString(final Object obj) {
        try {
            String json =new ObjectMapper().writeValueAsString(obj);
            return json;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
