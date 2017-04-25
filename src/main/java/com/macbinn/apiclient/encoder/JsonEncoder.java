package com.macbinn.apiclient.encoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.macbinn.apiclient.AbstractLogger;
import com.macbinn.apiclient.util.JSONUtil;

import java.io.IOException;
import java.util.Map;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public class JsonEncoder extends AbstractLogger implements Encoder {
    @Override
    public String encode(Object o) {
        try {
            return JSONUtil.OBJECT_MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            logger.error("json encode error", e);
        }
        return null;
    }

    @Override
    public String encode(Map<String, Object> params) {
        return encode((Object) params);
    }

    @Override
    public <T> T decode(String s, Class<T> clazz) {
        try {
            return JSONUtil.OBJECT_MAPPER.readValue(s, clazz);
        } catch (IOException e) {
            logger.error("json decode error", e);
        }
        return null;
    }
}
