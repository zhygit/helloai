package com.zhytech.helloai.WX.beans.message.req;

/**
 * Created by zhy on 2017/4/30.
 */
public class LinkMessage extends BaseMessage {
    private String Title;
    private String Description;
    private String Url;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
