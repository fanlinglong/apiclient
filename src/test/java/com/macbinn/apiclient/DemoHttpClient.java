package com.macbinn.apiclient;

import com.macbinn.apiclient.http.HttpClient;

/**
 * Created by ningzhibin on 2017/4/26.
 */
public class DemoHttpClient implements HttpClient {
    @Override
    public String get(String url) {
        return "{\"name\":\"macbinn\", \"age\":20}";
    }

    @Override
    public String post(String url, String body) {
        return "true";
    }
}
