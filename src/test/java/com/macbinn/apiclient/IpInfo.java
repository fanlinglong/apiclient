package com.macbinn.apiclient;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public class IpInfo {
    private int code;
    private IpInfoData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public IpInfoData getData() {
        return data;
    }

    public void setData(IpInfoData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IpInfo{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
