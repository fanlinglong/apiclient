package com.macbinn.apiclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public class Example {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    public static void main(String[] args) {
        TaobaoIpClient client = ApiClientFactory.getClient(TaobaoIpClient.class);

        String[] ips = {"123.56.47.221", "211.157.146.125"};
        for (String ip : ips) {
            logger.info("getIpInfo={}", client.getIpInfo(ip));
            logger.info("postIpInfo={}", client.postIpInfo(ip));
        }
    }
}
