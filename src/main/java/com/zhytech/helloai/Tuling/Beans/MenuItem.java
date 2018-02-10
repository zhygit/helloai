package com.zhytech.helloai.Tuling.Beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Bean;

/**
 * Created by zhy on 2017/3/23.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuItem {
    private String name;
    private String icon;
    private String info;
    private String detailurl;

    @Override
    public String toString() {
        return "MenuItem{" +
                "name: '" + name + '\'' +
                ", icon: '" + icon + '\'' +
                ", info: '" + info + '\'' +
                ", detailurl: '" + detailurl + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDetailurl() {
        return detailurl;
    }

    public void setDetailurl(String detailurl) {
        this.detailurl = detailurl;
    }
}
