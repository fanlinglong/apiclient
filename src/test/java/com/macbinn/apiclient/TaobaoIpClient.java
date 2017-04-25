package com.macbinn.apiclient;

import com.macbinn.apiclient.http.Http;
import com.macbinn.apiclient.http.HttpMethod;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public interface TaobaoIpClient {
    @Http(url = "http://ip.taobao.com/service/getIpInfo.php")
    IpInfo getIpInfo(@Param("ip") String ip);

    @Http(url = "http://ip.taobao.com/service/getIpInfo.php", method = HttpMethod.POST)
    IpInfo postIpInfo(@Param("ip") String ip);
}
