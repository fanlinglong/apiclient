package com.macbinn.apiclient;

import com.macbinn.apiclient.encoder.Encoders;
import com.macbinn.apiclient.http.Http;
import com.macbinn.apiclient.http.HttpMethod;

/**
 * Created by ningzhibin on 2017/4/25.
 */
public interface DemoClient {
    @Http(url = "http://demo.com/api/addData", method = HttpMethod.POST)
    boolean addData(@Param("data") String data);

    @Http(url = "http://demo.com/api/addUser", method = HttpMethod.POST, encoder = Encoders.Json)
    boolean addUser(User user);

    @Http(url = "http://demo.com/api/user/{name}/")
    User queryUser(@PathVar("name") String name);
}
