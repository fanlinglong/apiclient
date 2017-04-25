package com.macbinn.apiclient.http;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public interface HttpClient {
    String get(String url);
    String post(String url, String body);
}
