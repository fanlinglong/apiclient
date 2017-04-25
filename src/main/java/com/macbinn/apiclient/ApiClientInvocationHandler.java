package com.macbinn.apiclient;

import com.macbinn.apiclient.encoder.Encoder;
import com.macbinn.apiclient.encoder.Encoders;
import com.macbinn.apiclient.encoder.JsonEncoder;
import com.macbinn.apiclient.encoder.KeyValuePairsEncoder;
import com.macbinn.apiclient.http.Http;
import com.macbinn.apiclient.http.HttpClient;
import com.macbinn.apiclient.http.HttpMethod;
import com.macbinn.apiclient.http.SimpleHttpClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public class ApiClientInvocationHandler extends AbstractLogger implements InvocationHandler {

    private static final Map<Encoders, Encoder> encoderMap = new HashMap<>();

    static {
        encoderMap.put(Encoders.Json, new JsonEncoder());
        encoderMap.put(Encoders.KeyValuePairs, new KeyValuePairsEncoder());
    }

    private HttpClient httpClient = new SimpleHttpClient();

    private Encoder getEncoder(Encoders encoders) {
        return encoderMap.get(encoders);
    }

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Http httpAnnotation = method.getAnnotation(Http.class);
        String url = httpAnnotation.url();

        Map<String, Object> params = new HashMap<>();
        int i = 0;
        for (Parameter parameter : method.getParameters()) {
            Param paramAnnotation = parameter.getAnnotation(Param.class);
            logger.debug("parameter={}, paramAnnotation={}", parameter, paramAnnotation);
            params.put(paramAnnotation.value(), String.valueOf(objects[i++]));
        }

        String query = getEncoder(httpAnnotation.encoder()).encode(params);

        String responseBody = null;
        if (httpAnnotation.method() == HttpMethod.GET) {
            url = url + "?" + query;
            responseBody = httpClient.get(url);
            logger.debug("url={}", url);
        } else if (httpAnnotation.method() == HttpMethod.POST) {
            responseBody = httpClient.post(url, query);
            logger.debug("url={}, body={}", url, query);
        }

        Encoder decoder = getEncoder(httpAnnotation.decoder());

        return decoder.decode(responseBody, method.getReturnType());
    }
}
