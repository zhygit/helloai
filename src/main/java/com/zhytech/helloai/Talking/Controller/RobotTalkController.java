package com.zhytech.helloai.Talking.Controller;


import com.zhytech.helloai.Talking.Beans.Human;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autoTallk")
public class RobotTalkController {
    private static final Logger log = LoggerFactory.getLogger(RobotTalkController.class);

    private Human Adam;
    private Human Eve;


//    This is just a demo method;
    @RequestMapping("/godkick")
    public String AutoTalk(@RequestParam(required = false)String firstword) throws JSONException {
        Adam = new Human("Adam");
        Eve = new Human("Eve");
        String EveReply = "";
        String AdamReply = "";
        String result = "\n\r";
        Integer talkround = 50;
        String godkick = "ÄãºÃ£¡";
        if(null!=firstword&& !"".equals(firstword)){
            godkick = firstword;
        }
        AdamReply = Adam.humanAction.Say(godkick);
        for (int i=0;i<talkround;i++) {
            log.info("=== Round "+ Integer.toString(i) +" ====");

            log.info("Adam : "+AdamReply);
            result = result + "Adam : " + AdamReply +"\n";

            EveReply = Eve.humanAction.ReplyPureMsg(AdamReply);
            log.info("Eve  : "+EveReply);
            result = result + "Eve  : " + EveReply +"\n \n\r";
            AdamReply = Adam.humanAction.ReplyPureMsg(EveReply);

        }

        log.info(result);
        return result;

    }

    public static void main(String args[]) throws JSONException {
        RobotTalkController demo = new RobotTalkController();
        demo.AutoTalk("ÄãºÃ");

    }
}
