package com.zhytech.helloai.Baidu.Beans;

/**
 * Created by zhy on 2017/3/19.
 */
public class OauthParams {
    private static String default_client_id = "u9C1YKgEGFfNUtKIfZhU49CQ";
    private static String default_client_secret = "97f84c0ff40c2f9fc83d5e5a08910e98";
    private static String default_grant_type = "client_credentials";

    private String client_id;
    private String client_secret;
    private String grant_type;

    public OauthParams() {
        this.client_id = default_client_id;
        this.client_secret = default_client_secret;
        this.grant_type = default_grant_type;

    }

    @Override
    public String toString() {
        return "OauthParams{" +
                "client_id: '" + client_id + '\'' +
                ", client_secret: '" + client_secret + '\'' +
                ", grant_type: '" + grant_type + '\'' +
                '}';
    }

    public  String getClient_id() {
        return client_id;
    }

    public  void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public  String getClient_secret() {
        return client_secret;
    }

    public  void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public  String getGrant_type() {
        return grant_type;
    }

    public  void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
