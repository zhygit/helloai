package com.zhytech.helloai.WX.beans.message.req;

/**
 * Created by zhy on 2017/4/30.
 */
public class VoiceMessage extends BaseMessage {
    private String MediaId;
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
