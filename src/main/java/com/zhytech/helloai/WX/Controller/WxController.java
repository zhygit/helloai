package com.zhytech.helloai.WX.Controller;

import com.zhytech.helloai.WX.Utils.MessageUtils;
import com.zhytech.helloai.WX.Utils.XmlUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Created by zhy on 2017/4/12.
 */

@RestController
@RequestMapping(value = "/wx")
public class WxController {

    String token = "cxwork";
    String encodingAesKey = "AqHCZ38M5LV8FUIoekdHSKfNRlQ1ew41LcB2Cd1vza5";
    String appId = "wxb81c4d22981b40cb";


    public static final Logger logger = LoggerFactory.getLogger(WxController.class);

    @RequestMapping("hello")
    public String hello(HttpServletRequest request) {
        String headers =  request.getHeader("user");
        return "Hello Weixin API test "+headers +" OOOOOK";
    }

    //    @RequestMapping(value = "validURL")
    @RequestMapping(value = "api",method = RequestMethod.GET)
    public String validURL(@RequestParam(required = false) String signature, @RequestParam(required = false) String timestamp,
                           @RequestParam(required = false) String nonce, @RequestParam(required = false) String echostr,
                           @RequestBody(required = false) String fromXML) {
        logger.info("WxSignature: " + signature + " Wxtimestamp: " + timestamp + " Wxnonce: " + nonce + " Wxechostr: " + echostr);
        logger.debug("FromXml: ", fromXML);


        if (doValid(signature, token, timestamp, nonce)) {
            return echostr;
        } else
            return "Sorry! Please tell me who you are!";

    }

    @RequestMapping(value = "api",method = RequestMethod.POST)
    public String mainController(@RequestParam(required = false)String signature,@RequestParam(required = false) String timestamp,
                                 @RequestParam(required = false)String nonce,@RequestParam(required = false) String echostr,
                                 @RequestBody(required = false) String fromXML){
        logger.info("WxSignature: " + signature + " Wxtimestamp: " + timestamp + " Wxnonce: " + nonce + " Wxechostr: " + echostr);
        logger.info("FromXml: "+fromXML.toString());
        String returnMsg = "success";
        try {
            Map<String, String> map = XmlUtils.parseXmlToMap(fromXML);
            String msgType = map.get("MsgType");
            logger.info("======  A "+msgType+" Message Received  ======");
            MessageDispatcher messageDispatcher = new MessageDispatcher();
            if (MessageUtils.REQ_MESSAGE_TYPE_EVENT.equals(msgType)) {
                logger.info("======  Start to process [ Event ] Message  ======");
                EventDispatcher.processEvent(map);
            }else {
                logger.info("======  Start to process [ "+msgType+" ]Message ======");
                returnMsg = messageDispatcher.processMessage(map);
            }
        } catch (Exception e) {
            logger.error("======  Oooops! Some error occous  ======");
            e.printStackTrace();

        }

        logger.info("retrun wx: "+returnMsg);
        return returnMsg;

    }


    private String calculateSignaure(String token, String timestamp, String nonce) {
        ArrayList<String> list = new ArrayList<String>();
        list.add(token);
        list.add(timestamp);
        list.add(nonce);
        Collections.sort(list);
        String sig = DigestUtils.sha1Hex(list.get(0) + list.get(1) + list.get(2));
        logger.info("sig: " + sig);
        return sig;
    }

    public boolean doValid(String WxSignature, String token, String timestamp, String nonce) {
        String sig = calculateSignaure(token, timestamp, nonce);
        if (sig.equals(WxSignature)) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String args[]) {
        String signature = "90e223174681fb8df67d534a611b2461288c7d11";
        String echostr = "5303853878407905278";
        String timestamp = "1493479902";
        String nonce = "200001779";
        String token = "cxwork";
        logger.info("中文");
        WxController wx = new WxController();
        String sig = wx.calculateSignaure(token, timestamp, nonce);
        logger.info("sig  :" + sig);
        logger.info("wxsig:" + signature);
    }
}
