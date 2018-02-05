package com.zhytech.helloai.WX.beans.message.req;

/**
 * Created by zhy on 2017/4/30.
 */
public class TextMessage extends BaseMessage {
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
