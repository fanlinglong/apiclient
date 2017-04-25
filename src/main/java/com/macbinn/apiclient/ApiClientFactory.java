package com.macbinn.apiclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public class ApiClientFactory {

    private static final Logger logger = LoggerFactory.getLogger(ApiClientFactory.class);

    public static <T> T getClient(Class<T> clazz) {
        Class<T>[] classes = new Class[]{clazz};
        return (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), classes, new ApiClientInvocationHandler());
    }
}
