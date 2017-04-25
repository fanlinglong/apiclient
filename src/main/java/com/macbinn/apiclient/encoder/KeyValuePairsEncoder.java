package com.macbinn.apiclient.encoder;

import com.macbinn.apiclient.AbstractLogger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public class KeyValuePairsEncoder extends AbstractLogger implements Encoder {

    private static final String STRING_ENCODE = "UTF-8";

    @Override
    public String encode(Object o) {
        return null;
    }

    @Override
    public String encode(Map<String, Object> params) {
        StringBuffer sb = new StringBuffer();
        Set<Map.Entry<String, Object>> entries = params.entrySet();
        int i = 0;
        for (Map.Entry<String, Object> entry : entries) {
            sb.append(entry.getKey());
            sb.append("=");
            try {
                sb.append(URLEncoder.encode(String.valueOf(entry.getValue()), STRING_ENCODE));
            } catch (UnsupportedEncodingException e) {
                logger.error("encode error", e);
            }
            if (++i < entries.size()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    @Override
    public <T> T decode(String s, Class<T> clazz) {
        return null;
    }
}
