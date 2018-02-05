package com.zhytech.helloai.Config;

import com.zhytech.helloai.Tuling.Utils.TulingResponseConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by zhy on 2017/7/15.
 */
@Configuration
@EnableWebMvc
public class MyMvcConfig extends WebMvcConfigurerAdapter{


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        TulingResponseConverter converter = new TulingResponseConverter();
        converters.add(converter);
    }

    @Bean
    public  TulingResponseConverter converter(){
        return new TulingResponseConverter();
    }
}
