package com.zhytech.helloai.Baidu.Service;

import com.zhytech.helloai.Baidu.Beans.TsnParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;

/**
 * Created by zhy on 2017/3/21.
 */

@Service
public class TsnServiceItfImpl implements TsnServiceItf {
    private static final Logger log = LoggerFactory.getLogger(TsnServiceItfImpl.class);
    private static final String tex2audioURL ="http://tsn.baidu.com/text2audio";
    private TsnParams tsnParams;

    @Override
    public String tex2audio(String tex) {
        RestTemplate restTemplate = new RestTemplate();
        tsnParams = new TsnParams(tex2utf8(tex));
        return restTemplate.getForObject(tex2audioURL+"?tex={tex}&lan={lan}&cuid={cuid}&ctp={ctp}&tok={tok}",
                String.class, tsnParams.getTex(),tsnParams.getLan(),tsnParams.getCuid(),tsnParams.getCtp(),tsnParams.getTok());
    }

    @Override
    public String tex2audio(String url, String tex) {
        RestTemplate restTemplate = new RestTemplate();
        tsnParams = new TsnParams(tex2utf8(tex));
        return restTemplate.getForObject(url, String.class, tsnParams);

    }

    public ResponseEntity<byte[]> tex2audiomp3(String tex){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        tsnParams = new TsnParams(tex2utf8(tex));
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        ResponseEntity<byte[]> response = restTemplate.exchange(tex2audioURL + "?tex={tex}&lan={lan}&cuid={cuid}&ctp={ctp}&tok={tok}",
                HttpMethod.GET, new HttpEntity<byte[]>(headers), byte[].class,tsnParams.getTex(),tsnParams.getLan(),tsnParams.getCuid(),tsnParams.getCtp(),tsnParams.getTok());
        return response;
    }

    public String tex2utf8(String tex) {
        String tex2utf8 = "default";
        try {
            if (tex == null || "".equals(tex)) {
                return "text is null";
            } else {
                tex2utf8 = URLEncoder.encode(tex, "utf-8");
                log.debug("tex: " + tex);
                log.debug("tex2utf8: " + tex2utf8);
                if (tex2utf8.length() > 1024) {
                    log.info("String length : ", tex2utf8.length());
                    return "text is too long ";
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return tex2utf8;
    }


}
