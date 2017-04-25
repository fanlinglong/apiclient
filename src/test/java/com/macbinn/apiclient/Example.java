package com.macbinn.apiclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public class Example {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    private static void testTaobao() {
        TaobaoIpClient client = ApiClientFactory.getClient(TaobaoIpClient.class);

        String[] ips = {"123.56.47.221", "211.157.146.125"};
        for (String ip : ips) {
            logger.info("getIpInfo={}", client.getIpInfo(ip));
            logger.info("postIpInfo={}", client.postIpInfo(ip));
        }
    }

    private static void testDemo() {
        DemoClient client = ApiClientFactory.getClient(DemoClient.class, new DemoHttpClient());
        User user = new User();
        user.setName("macbinn");
        user.setAge(20);
        logger.info("addUser: {}", client.addUser(user));
        logger.info("queryUser: {}", client.queryUser(user.getName()));
        logger.info("addData: {}", client.addData("hello world"));
    }

    public static void main(String[] args) {
        testDemo();
        testTaobao();
    }
}
