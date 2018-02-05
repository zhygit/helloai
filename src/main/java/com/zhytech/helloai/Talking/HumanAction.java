package com.zhytech.helloai.Talking;

import com.zhytech.helloai.Tuling.Service.TulingService;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class HumanAction {
    private static final Logger log = LoggerFactory.getLogger(HumanAction.class);

    private TulingService tulingService;


    public String Say(String text) {
        return text;
    }

    public String Reply(String text){
        tulingService = new TulingService();
        String replyStr = tulingService.TulingTalk(text);
        return replyStr;

    }

    public String ReplyPureMsg(String text) throws JSONException {
        tulingService = new TulingService();
        String replyStr = tulingService.TulingTalk(text);
        JSONObject ob = new JSONObject(replyStr);
        return ob.getString("text");
    }

    public static void main(String args[]) throws JSONException {
        HumanAction humanAction = new HumanAction();
        String t = humanAction.Reply("ÄãºÃ");
        log.info(t);
        log.info(humanAction.ReplyPureMsg("ÄúºÃ"));
    }
}
