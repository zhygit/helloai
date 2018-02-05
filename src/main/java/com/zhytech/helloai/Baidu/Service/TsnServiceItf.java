package com.zhytech.helloai.Baidu.Service;

import org.springframework.http.ResponseEntity;

/**
 * Created by zhy on 2017/3/21.
 */
public interface TsnServiceItf {
    public String tex2audio(String tex);

    public String tex2audio(String url, String tex);

    public ResponseEntity<byte[]> tex2audiomp3(String tex);
}
