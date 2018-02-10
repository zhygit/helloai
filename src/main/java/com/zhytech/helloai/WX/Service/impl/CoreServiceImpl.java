package com.zhytech.helloai.WX.Service.impl;

import com.zhytech.helloai.Baidu.Service.TsnServiceItfImpl;
import com.zhytech.helloai.Tuling.Beans.MenuItem;
import com.zhytech.helloai.Tuling.Beans.ResponseItem;
import com.zhytech.helloai.Tuling.Beans.TuliingRespone;
import com.zhytech.helloai.Tuling.Service.TulingService;
import com.zhytech.helloai.Tuling.Utils.TulingObjectConverter;
import com.zhytech.helloai.Tuling.Utils.TulingResponeType;
import com.zhytech.helloai.WX.Service.CoreService;
import com.zhytech.helloai.WX.Utils.MessageUtils;
import com.zhytech.helloai.WX.Utils.XmlUtils;
import com.zhytech.helloai.WX.beans.message.resp.Article;
import com.zhytech.helloai.WX.beans.message.resp.NewsMessageResp;
import com.zhytech.helloai.WX.beans.message.resp.TextMessageResp;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhy on 2017/5/1.
 */

@Service
public class CoreServiceImpl implements CoreService{
    public static Logger logger = LoggerFactory.getLogger(CoreServiceImpl.class);

    private TsnServiceItfImpl tsnService;


    public String processTextMessage(Map<String, String> map) {
        String replyContent = "Hello! This is my Reply! "+ map.get("Content");
//        return replyTextMsg(map, replyContent);
//        replyWhatYouSay(map);
        return AITalk(map);


    }

    public String processVoideMessage(Map<String, String> map) {

        return null;
    }

    public String replyVoiceMsg(Map<String, String> map) {
        return null;
    }


    public String AITalk(Map<String,String > map)  {
        TulingService ts = new TulingService();
        String info = map.get("Content");
        String userid = map.get("FromUserName");
        logger.info("User Content : " + info+" ; FormUser : "+userid);
        String answer = ts.TulingTalk(info,userid);
        logger.info("Answer : "+answer);
        TulingObjectConverter tulingObjectConverter = new TulingObjectConverter();
        TuliingRespone tuliingRespone = tulingObjectConverter.converter(answer);
        String WxXMLString = null;
        switch (tuliingRespone.getCode()) {
            case "100000":
                String text = tuliingRespone.getText();
                logger.info("text: "+text);
                WxXMLString = replyTextMsg(map, text);
                break;
            case "308000":
            case "302000":
            case "200000":
                WxXMLString = replyNewsMsg(map, tuliingRespone);
                break;
        }

        logger.info("Return WxXML : "+WxXMLString);
        return WxXMLString;

    }

    private String GetUrl(String s){
        String url = "";
        try {
            JSONObject jsonObject = new JSONObject(s);
            url = jsonObject.getString("url");
        } catch (Exception e) {
            url = s;
            e.printStackTrace();

        }
        return url;
    }
    private String GetText(String s){
        String text = "";
        try {
            JSONObject jsonObject = new JSONObject(s);
            text = jsonObject.getString("text");
        } catch (Exception e) {
            text = s;
            e.printStackTrace();

        }
        return text;
    }

    public String replyTextMsg(Map<String,String> map, String replyContent) {

        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        String msgType = map.get("MsgType");
        TextMessageResp textMessageResp = new TextMessageResp();
        textMessageResp.setToUserName(fromUserName);
        textMessageResp.setFromUserName(toUserName);
        textMessageResp.setCreateTime(new Date().getTime());
        textMessageResp.setMsgType(MessageUtils.RESP_MESSAGE_TYPE_TEXT);
        textMessageResp.setFuncFlag(0);
        textMessageResp.setContent(replyContent);
        return XmlUtils.textMessageToXml(textMessageResp);
    }


    public String replyNewsMsg(Map<String, String> map, TuliingRespone tuliingRespone) {
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        NewsMessageResp newsMessageResp = new NewsMessageResp();
        newsMessageResp.setToUserName(fromUserName);
        newsMessageResp.setFromUserName(toUserName);
        newsMessageResp.setMsgType(MessageUtils.RESP_MESSAGE_TYPE_NEWS);
        newsMessageResp.setFuncFlag(0);

        int ArticleCount = tuliingRespone.getList().size();
        logger.info("Repsone item count : "+ArticleCount);
        if (ArticleCount > 8) {
            ArticleCount = 8;
        }
        newsMessageResp.setArticleCount(ArticleCount);
        List<Article> articlelist = new ArrayList<>();
        for (int i=0;i<ArticleCount;i++){
            Article articleItem = new Article();
            ResponseItem responseItem = new ResponseItem();
            responseItem = tuliingRespone.getList().get(i);
            articleItem.setTitle(responseItem.getName());
            articleItem.setDescription(responseItem.getInfo());
            articleItem.setPicUrl(responseItem.getIcon());
            articleItem.setUrl(responseItem.getDetailurl());
            articlelist.add(articleItem);
        }
        newsMessageResp.setArticles(articlelist);
        return XmlUtils.newsMessageToXml(newsMessageResp);
    }



    public String replyWhatYouSay(Map<String,String> map){
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        String msgType = map.get("MsgType");
        TextMessageResp textMessageResp = new TextMessageResp();
        textMessageResp.setToUserName(fromUserName);
        textMessageResp.setFromUserName(toUserName);
        textMessageResp.setCreateTime(new Date().getTime());
        textMessageResp.setMsgType(MessageUtils.RESP_MESSAGE_TYPE_TEXT);
        textMessageResp.setFuncFlag(0);
        textMessageResp.setContent(map.get("Content"));
        return XmlUtils.textMessageToXml(textMessageResp);

    }

    public String processVoiceMessage(Map<String, String> map) {
        return null;

    }

    public String processImageMessage(Map<String,String> map){
        String ReplyText = "¾ÍÄã»á·¢Í¼Æ¬°¡~";
        return replyTextMsg(map,ReplyText);
    }
}
