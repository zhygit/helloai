package com.zhytech.helloai.Tuling.Controller;

import com.zhytech.helloai.Tuling.Beans.TuliingRespone;
import com.zhytech.helloai.Tuling.Service.TulingService;
import com.zhytech.helloai.Tuling.Utils.TulingResponseConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhy on 2017/7/16.
 */

@RestController
@RequestMapping(value = "/tuling")
public class TulingController {

    private static final Logger log = LoggerFactory.getLogger(TulingController.class);
    private static String APIkey = "3d959839f2cb4cbfaed25afc256b0f71";
    private static String TulingApiUrl = "http://www.tuling123.com/openapi/api";

    @RequestMapping("/talkapi")
    public @ResponseBody TuliingRespone TalkToTuling(String info){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new TulingResponseConverter());

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<String,String>();
        requestEntity.add("key",APIkey);
        requestEntity.add("info",info);
        requestEntity.add("loc","北京");
        requestEntity.add("userid","123456");
        TuliingRespone tuliingRespone = new TuliingRespone();
        tuliingRespone = restTemplate.getForObject(TulingApiUrl + "?key={key}&info={info}&userid=1231234",
                TuliingRespone.class, APIkey,info);
        return tuliingRespone;

    }


}
