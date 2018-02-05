package com.zhytech.helloai.WX.Service;

import java.util.Map;

/**
 * Created by zhy on 2017/5/1.
 */
public interface CoreService {

    public String processTextMessage(Map<String, String> map);

    public String replyTextMsg(Map<String, String> map, String replyContent);


}
