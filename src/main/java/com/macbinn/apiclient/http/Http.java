package com.macbinn.apiclient.http;

import com.macbinn.apiclient.encoder.Encoders;

import java.lang.annotation.*;

/**
 * Created by zhibin.ning on 17-4-25.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Http {
    HttpMethod method() default HttpMethod.GET;
    String url();
    Encoders encoder() default Encoders.KeyValuePairs;
    Encoders decoder() default Encoders.Json;
}
