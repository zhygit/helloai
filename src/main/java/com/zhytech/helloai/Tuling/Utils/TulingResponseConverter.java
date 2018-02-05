package com.zhytech.helloai.Tuling.Utils;

import com.zhytech.helloai.Tuling.Beans.TuliingRespone;
import com.zhytech.helloai.WX.Controller.WxController;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by zhy on 2017/5/7.
 */
public class TulingResponseConverter extends AbstractHttpMessageConverter<TuliingRespone> {

    public static final Logger logger = LoggerFactory.getLogger(WxController.class);
    public TulingResponseConverter() {
        super(new MediaType("text","json",Charset.forName("UTF-8")));
    }

    @Override
    protected TuliingRespone readInternal(Class<? extends TuliingRespone> clazz,
                                          HttpInputMessage inputMessage)throws IOException,HttpMessageNotReadableException{
        String temp = StreamUtils.copyToString(inputMessage.getBody(),Charset.forName("UTF-8"));
        logger.info("http input String : "+temp);
        TuliingRespone tuliingRespone = new TuliingRespone();
        try {
            JSONObject ob = new JSONObject(temp);
            tuliingRespone.setText(ob.getString("text"));
            tuliingRespone.setCode(ob.getString("code"));
            if(ob.has("url")){
                tuliingRespone.setUrl(ob.getString("url"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tuliingRespone;

    }

    @Override
    protected boolean supports(Class<?> clazz){
        return TuliingRespone.class.isAssignableFrom(clazz);
    }

    @Override
    protected void writeInternal(TuliingRespone tuliingRespone, HttpOutputMessage outputMessage)
        throws IOException,HttpMessageNotWritableException{
        String out = "Hello Tuling: "+tuliingRespone.getText();
        outputMessage.getBody().write(out.getBytes());
    }


}

