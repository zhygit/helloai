package com.zhytech.helloai.Baidu.Controller;

import com.zhytech.helloai.Baidu.Beans.OauthParams;
import com.zhytech.helloai.WX.beans.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhy on 2017/3/12.
 *
 * API Key: u9C1YKgEGFfNUtKIfZhU49CQ
 * Secret Key: 97f84c0ff40c2f9fc83d5e5a08910e98
 *
 *
 * getToken:
 * https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id=u9C1YKgEGFfNUtKIfZhU49CQ&client_secret=97f84c0ff40c2f9fc83d5e5a08910e98
 *
 * return:
 * {
 "access_token": "24.71ad2030d889865c052025e58c5cfa53.2592000.1491923428.282335-9362314",
 "session_key": "9mzdDATKdxqL2LUVLoOVgPw52VpZSRcWvqQUNDfArue+3OmX6zDW9C1J2kYyVloOanbuvZkBReqY++QaTC+bZffvYfJO",
 "scope": "public audio_voice_assistant_get audio_tts_post wise_adapt lebo_resource_base lightservice_public hetu_basic lightcms_map_poi kaidian_kaidian wangrantest_test wangrantest_test1 bnstest_test1 bnstest_test2 ApsMisTest_Test权限 vis-classify_flower",
 "refresh_token": "25.380f07d823e8681455f2943319dcc915.315360000.1804691428.282335-9362314",
 "session_secret": "b0a35f1bb536c5fb90c38fd6ee1f5db2",
 "expires_in": 2592000
 }
 *
 * get合成语音
 * http://tsn.baidu.com/text2audio?tex=%E5%8C%97%E4%BA%AC%E4%BB%8A%E5%A4%A9%E7%9A%84%E6%B8%A9%E5%BA%A6%E6%98%AF17%E5%BA%A6&lan=zh&tok=24.71ad2030d889865c052025e58c5cfa53.2592000.1491923428.282335-9362314&ctp=1&cuid=aslkdjgogwnenasdvlwiegansleghagn
 */

@Service
public class OauthController {
    private static final Logger log = LoggerFactory.getLogger(OauthController.class);
    private static String client_id = "u9C1YKgEGFfNUtKIfZhU49CQ";
    private static String client_secret = "97f84c0ff40c2f9fc83d5e5a08910e98";
    private static String grant_type = "client_credentials";
    private static String baiduTokenApi = "http://openapi.baidu.com/oauth/2.0/token";


    private OauthParams oauthParams;

    public Token getAccessToken(){
        RestTemplate rs = new RestTemplate();
        oauthParams = new OauthParams();
        Token t = rs.getForObject(baiduTokenApi
                        + "?client_id={client_id}&client_secret={client_secret}&grant_type={grant_type}",
                Token.class, client_id, client_secret, grant_type);
        log.info(t.toString());
        return t;

    }

    public Token postForAccessToken(){
        RestTemplate rt = new RestTemplate();

        OauthParams op = new OauthParams();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

        params.add("client_id", op.getClient_id());
        params.add("client_secret", op.getClient_secret());
        params.add("grant_type", op.getGrant_type());
        log.info("params: " + params.toString());

        Token t = rt.postForObject(baiduTokenApi, params,Token.class);
        log.info(t.toString());
        return t;
    }


    public static void main(String args[]){
        OauthController o =new OauthController();

        log.debug("Get AccessToken ===");
        o.getAccessToken();
        log.debug("Post For Access Token =====");
        o.postForAccessToken();

    }

}
