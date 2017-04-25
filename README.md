### 一分钟快速教程

我在项目里需要调用一个API接口，例如：淘宝的IP查询接口

```shell
$ curl "http://ip.taobao.com/service/getIpInfo.php?ip=123.56.47.221"
{
	code: 0,
	data: {
		country: "中国",
		country_id: "CN",
		area: "华北",
		area_id: "100000",
		region: "北京市",
		region_id: "110000",
		city: "北京市",
		city_id: "110100",
		county: "",
		county_id: "-1",
		isp: "阿里云",
		isp_id: "1000323",
		ip: "123.56.47.221"
	}
}
```

#### 定义数据POJO

接口返回的IP数据

```java
public class IpInfo {
    public int code;
    public IpInfoData data;
}

public class IpInfoData {
    public String ip;
    public String country;
    public String area;
    public String region;
    public String city;
    public String isp;
}
```

#### 定义接口

```java
public interface TaobaoIpClient {
    @Http(url = "http://ip.taobao.com/service/getIpInfo.php")
    IpInfo getIpInfo(@Param("ip") String ip);
}
```

#### 调用client

```java
TaobaoIpClient client = ApiClientFactory.getClient(TaobaoIpClient.class);
client.getIpInfo("123.56.47.221"); // 返回IpInfo
```

