package com.zhytech.helloai.Tuling.Beans;

public class ResponseItem {
    private String name;
    private String icon;
    private String info;
    private String detailurl;
    private String article;

    @Override
    public String toString() {
        return "ResponseItem{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", info='" + info + '\'' +
                ", detailurl='" + detailurl + '\'' +
                ", article='" + article + '\'' +
                ", soucre='" + soucre + '\'' +
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

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getSoucre() {
        return soucre;
    }

    public void setSoucre(String soucre) {
        this.soucre = soucre;
    }

    private String soucre;

}
