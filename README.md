### 一分钟快速教程

我在项目里需要调用一个API接口，例如：淘宝的IP查询接口

```shell
$ curl "http://ip.taobao.com/service/getIpInfo.php?ip=123.56.47.221"
{
    "code": 0,
    "data": {
        "country": "中国",
        "area": "华北",
        "region": "北京市",
        "city": "北京市",
        "isp": "阿里云",
        "ip": "123.56.47.221"
    }
}
```

只要简单三步，就可以在项目里实现快速调用接口

#### 1、定义数据POJO

```java
// 这里用public做演示，实际项目还是用private和setter/getter来定义POJO哦
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

#### 2、定义Client接口

```java
public interface TaobaoIpClient {
    @Http(url = "http://ip.taobao.com/service/getIpInfo.php")
    IpInfo getIpInfo(@Param("ip") String ip);
}
```

#### 3、调用client

```java
TaobaoIpClient client = ApiClientFactory.getClient(TaobaoIpClient.class);
client.getIpInfo("123.56.47.221"); // 返回IpInfo
```

这就就OK了，是不是很简单。



### 常见用法

从上面的例子可以看到，关键步骤就在于第二步如何定义接口，下面是一些常见的用法。

#### 1、Post数据

```shell
$ curl "http://demo.com/api/addData" -d "data=hello"
true
```

Client定义如下：

```java
public interface DemoClient {
    @Http(url = "http://demo.com/api/addData", method = HttpMethod.POST)
    boolean add(@Param("data") String data);
}
```

#### 2、JSON数据

```shell
$ curl "http://demo.com/api/addUser" -d '{"name":"macbinn","age":20}'
```

Client定义如下：

```java
public class User {
  public String name;
  public int age;
}

public interface DemoClient {
    @Http(url = "http://demo.com/api/addUser", method = HttpMethod.POST,
          encoder = Encoders.Json)
    boolean add(User user);
}
```



