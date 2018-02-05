package com.zhytech.helloai.Tuling.Service;

import com.zhytech.helloai.Tuling.Beans.TuliingRespone;
import com.zhytech.helloai.Tuling.Utils.TulingResponseConverter;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by zhy on 2017/3/23.
 */
@Service
public class TulingService {

    private static final Logger log = LoggerFactory.getLogger(TulingService.class);
    private static String APIkey = "3d959839f2cb4cbfaed25afc256b0f71";
    private static String TulingApiUrl = "http://www.tuling123.com/openapi/api";

//    当前使用的 方法
    public String TulingTalk(String info){
        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("key", APIkey);
//        params.put("info", "?????");
//        params.put("loc", "??????");
//        params.put("userid", "12341234");

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<String,String>();
        requestEntity.add("key",APIkey);
        requestEntity.add("info",info);
        requestEntity.add("loc","北京市");
        requestEntity.add("userid","123456");
        String response;
        response = restTemplate.postForObject(TulingApiUrl, requestEntity, String.class);
        return response;

    }

    public String TulingTalk(String info,String userid){
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<String,String>();
        requestEntity.add("key",APIkey);
        requestEntity.add("info",info);
        requestEntity.add("loc","北京市");
        requestEntity.add("userid",userid);
        String response;
        response = restTemplate.postForObject(TulingApiUrl, requestEntity, String.class);
        return response;

    }

    public @ResponseBody TuliingRespone TulingTalk2(String info){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());


        //text/json
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("text","json")));


        Map<String, String> params = new HashMap<String, String>();
        params.put("key", APIkey);
        params.put("info", "测试测试");
        params.put("loc", "北京");
        params.put("userid", "12341234");

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<String,String>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        requestEntity.add("key",APIkey);
        requestEntity.add("info",info);
        requestEntity.add("loc","北京");
        requestEntity.add("userid","123456");
        TuliingRespone tuliingRespone = new TuliingRespone();
        tuliingRespone = restTemplate.postForObject(TulingApiUrl, requestEntity, TuliingRespone.class);
        return tuliingRespone;

    }

    public @ResponseBody TuliingRespone TulingTalk3(String info){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new TulingResponseConverter());
//        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
////        restTemplate.setMessageConverters(getMessageConverters());
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
////        headers.setAccept(Collections.singletonList(MediaType.ALL));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<String,String>();
        requestEntity.add("key",APIkey);
        requestEntity.add("info",info);
        requestEntity.add("loc","北京");
        requestEntity.add("userid","123456");
        TuliingRespone tuliingRespone = new TuliingRespone();
//      ResponseEntity<TuliingRespone> tuliingResponeResponseEntity =
//                restTemplate.exchange(TulingApiUrl, HttpMethod.GET, entity, TuliingRespone.class, requestEntity);
        tuliingRespone = restTemplate.getForObject(TulingApiUrl + "?key={key}&info={info}&userid=1231234",
                TuliingRespone.class, APIkey,info);
        return tuliingRespone;

//        return tuliingResponeResponseEntity.getBody();

    }


    public static void main(String args[]){
        TulingService t1 = new TulingService();
        TulingService t2 = new TulingService();
try{
    String godkick = "你好啊";
    Integer talkround = 10;
    String Adam =godkick;
    String Eve = "";
    JSONObject ob1 = null;
    JSONObject ob2 = null;
    log.info("Talking Start");
    log.info("=== Round 1 =====");
    log.info(Adam);
    for (int i=0;i<talkround;i++){
        ob1 = new JSONObject(Adam);
        log.info("Adam : "+ ob1.getString("text"));
        Eve = t1.TulingTalk(Adam);

        ob2 = new JSONObject(Eve);
        log.info("Eve : " +ob2.getString("text"));
        Adam = t2.TulingTalk(Eve);



    }
    log.info("Goodbye, Guys!");
}catch (JSONException e) {

            e.printStackTrace();

        }



//****  Test 1   ****//
//        TulingService t = new TulingService();
//        String info = "北京天气怎么样?";
//        String s = t.TulingTalk(info);
//        log.info("s :"+s);
//        try {
//            JSONObject ob = new JSONObject(s);
//            log.info(ob.toString());
//            log.info(ob.getString("text"));
////            if(null!=ob.getString("url")){
////                log.info(ob.getString("url"));
////            }else {
////                log.info("No Url Return!");
////            }
//
//        } catch (JSONException e) {
//
//            e.printStackTrace();
//
//        }
//
//        log.info("++++++++++++++++++=\n\r\n\r");
//        TuliingRespone tuliingRespone = t.TulingTalk3("今天天气怎么样?");
//        log.info("TulingResponse  : ", tuliingRespone.toString());

//****  Test 1   ****//
    }

}

