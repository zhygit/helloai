package com.zhytech.helloai.Baidu.Controller;

import com.zhytech.helloai.Baidu.Service.TsnServiceItfImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhy on 2017/3/21.
 */

@RestController
@RequestMapping(value = "/text2audio")
public class TsnController {
    public static final Logger log = LoggerFactory.getLogger(TsnController.class);

    private static String apiurl = "http://tsn.baidu.com/text2audio";
    private String default_lan ="zh";
    private String default_ctp = "1";
    private String default_cuid ="1234qwer1324qwer";
    private String default_spd = "5";
    private String default_pit = "5";
    private String default_vol = "5";
    private String default_per = "3";

    @Autowired
    public TsnServiceItfImpl tsnService;

    public void initTsnParams(){
//        tsnParams = new TsnParams();
    }

    @RequestMapping(value = "/text/{tex}")
    public String text2audio(@PathVariable String tex){

        return tsnService.tex2audio(tex);

    }
    @RequestMapping(value = "/mp3/{tex}")
    public ResponseEntity<byte[]> text2mp3(@PathVariable String tex){
        return tsnService.tex2audiomp3(tex);
    }


}
