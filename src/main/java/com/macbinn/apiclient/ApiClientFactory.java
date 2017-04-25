package com.macbinn.apiclient;

import com.macbinn.apiclient.http.HttpClient;
import com.macbinn.apiclient.http.SimpleHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public class ApiClientFactory {

    private static final Logger logger = LoggerFactory.getLogger(ApiClientFactory.class);

    private static final HttpClient DEFAULT_HTTP_CLIENT = new SimpleHttpClient();

    public static <T> T getClient(Class<T> clazz) {
        return getClient(clazz, DEFAULT_HTTP_CLIENT);
    }

    public static <T> T getClient(Class<T> clazz, HttpClient httpClient) {
        Class<T>[] classes = new Class[]{clazz};
        return (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), classes,
                new ApiClientInvocationHandler(httpClient));
    }
}
