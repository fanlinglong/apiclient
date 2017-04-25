package com.macbinn.apiclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public abstract class AbstractLogger {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
}
