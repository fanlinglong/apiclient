package com.macbinn.apiclient;

import java.lang.annotation.*;

/**
 * Created by zhibin.ning on 17-4-25.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {
    String value();
}
