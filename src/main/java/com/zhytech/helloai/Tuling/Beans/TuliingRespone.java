package com.zhytech.helloai.Tuling.Beans;


import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhytech.helloai.Tuling.Beans.MenuItem;

/**
 * Created by zhy on 2017/3/23.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TuliingRespone {
    private String code;
    private String text;
    private String url;
    private List<MenuItem> list;
    private Function funciton;

    public TuliingRespone() {
    }

    public TuliingRespone(String s) {

    }

    @Override
    public String toString() {
        return "TuliingRespone{" +
                "code : '" + code + '\'' +
                ", text : '" + text + '\'' +
                ", url : '" + url + '\'' +
                ", list : " + list +
                ", funciton : " + funciton +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuItem> getList() {
        return list;
    }

    public void setList(List<MenuItem> list) {
        this.list = list;
    }

    public Function getFunciton() {
        return funciton;
    }

    public void setFunciton(Function funciton) {
        this.funciton = funciton;
    }
}
