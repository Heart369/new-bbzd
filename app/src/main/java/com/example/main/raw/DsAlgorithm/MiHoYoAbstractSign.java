package com.example.main.raw.DsAlgorithm;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.SecureRandom;
import java.util.*;

/**
 * 网址必要的请求头/Cookie/DS算法
 *
 * &#064;Author  Light rain
 * &#064;Date  2022/5/20 12:08
 */
public class MiHoYoAbstractSign {
    //构造器注入
    public final String cookie;
    //构造器注入
    public final String uid;
    //服务器id
    public String region;
    //类型
    private String clientType="5";
    //版本号
    private String appVersion="2.3.0";
    //校验码
    private String salt="9nQiU3AV0rJSIBWgdynfoGMGKaklfbM7";

    public MiHoYoAbstractSign(String cookie, String uid) {
        this.cookie = cookie;
        this.uid = uid;
    }

    public MiHoYoAbstractSign(String cookie) {
        this.cookie = cookie;
        this.uid = "";
    }

    //空参数构造器cookie/uid必须初始化
    public MiHoYoAbstractSign() {
        this.cookie = "";
        this.uid = "";
    }

    /**
     * 重写接口请求头getHeaders方法
     *
     * @return Header[]
     */

    /**
     * 请求头基本参数
     *
     * @return Header[]
     */


    /**
     * 原神签到DS算法
     *
     * @return String
     */
    public String getDS() {
        String i = (System.currentTimeMillis() / 1000) + "";
        String r = getRandomStr();
        return createDS(getSalt(), i, r);
    }

    /**
     * 获取随机字符串用于DS算法中
     *
     * @return String
     */
    protected String getRandomStr() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 6; i++) {
            String CONSTANTS = "abcdefghijklmnopqrstuvwxyz0123456789";
            int number = random.nextInt(CONSTANTS.length());
            char charAt = CONSTANTS.charAt(number);
            sb.append(charAt);
        }
        return sb.toString();
    }

    /**
     * 创建DS算法
     *
     * @param n salt
     * @param i t
     * @param r r
     * @return String
     */
    private String createDS(String n, String i, String r) {
        String c = DigestUtils.md5Hex("salt=" + n + "&t=" + i + "&r=" + r);
        return String.format("%s,%s,%s", i, r, c);
    }


//<editor-fold defaultstate="collapsed" desc="delombok">
//</editor-fold>


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public String getCookie() {
        return this.cookie;
    }

    @SuppressWarnings("all")
    public String getUid() {
        return this.uid;
    }

    @SuppressWarnings("all")
    public String getRegion() {
        return this.region;
    }

    @SuppressWarnings("all")
    public String getClientType() {
        return this.clientType;
    }

    @SuppressWarnings("all")
    public String getAppVersion() {
        return this.appVersion;
    }

    @SuppressWarnings("all")
    public String getSalt() {
        return this.salt;
    }

    @SuppressWarnings("all")
    public void setRegion(final String region) {
        this.region = region;
    }

    @SuppressWarnings("all")
    public void setClientType(final String clientType) {
        this.clientType = clientType;
    }

    @SuppressWarnings("all")
    public void setAppVersion(final String appVersion) {
        this.appVersion = appVersion;
    }

    @SuppressWarnings("all")
    public void setSalt(final String salt) {
        this.salt = salt;
    }
    //</editor-fold>
}

