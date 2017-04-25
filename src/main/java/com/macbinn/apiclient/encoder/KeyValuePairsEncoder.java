package com.macbinn.apiclient.encoder;

import com.macbinn.apiclient.AbstractLogger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public class KeyValuePairsEncoder extends AbstractLogger implements Encoder {

    private static final String STRING_ENCODE = "UTF-8";

    @Override
    public String encode(Map<String, Object> params) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            try {
                sb.append(URLEncoder.encode(String.valueOf(entry.getValue()), STRING_ENCODE));
            } catch (UnsupportedEncodingException e) {
                logger.error("encode error", e);
            }
        }
        return sb.toString();
    }

    @Override
    public <T> T decode(String s, Class<T> clazz) {
        return null;
    }
}
