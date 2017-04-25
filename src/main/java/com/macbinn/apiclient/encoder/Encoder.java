package com.macbinn.apiclient.encoder;

import java.util.Map;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public interface Encoder {
    String encode(Object o);
    String encode(Map<String, Object> params);
    <T> T decode(String s, Class<T> clazz);
}
