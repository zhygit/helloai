package com.zhytech.helloai.WX.Controller;

import com.zhytech.helloai.WX.Utils.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
/**
 * Created by zhy on 2017/5/1.
 */
public class EventDispatcher {
    public static Logger log = LoggerFactory.getLogger(EventDispatcher.class);

    public static void processEvent(Map<String, String> map) {
        String msgType = map.get("EventType");
        switch (msgType) {
            case MessageUtils.EVENT_TYPE_SUBSCRIBE:
                log.info("======  Subscribe Event  ======");
                break;
            case MessageUtils.EVENT_TYPE_CLICK:
                log.info("======  Click Event ======");
                break;
            case MessageUtils.EVENT_TYPE_SCAN:
                log.info("======  Scan Event ======");
                break;
            case MessageUtils.EVENT_TYPE_VIEW:
                log.info("======  View Event ======");
                break;
            case MessageUtils.EVENT_TYPE_UNSUBSCRIBE:
                log.info("======  Unsubscribe Event  ======");
                break;

        }
    }
}
