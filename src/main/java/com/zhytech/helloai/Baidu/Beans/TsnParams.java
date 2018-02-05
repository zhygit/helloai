package com.zhytech.helloai.Baidu.Beans;

/**
 * Created by zhy on 2017/3/21.
 */
public class TsnParams {
//    合成文版 UTF-8 长度<1024
    private String tex;
//  语言选择 zh
    private String lan;
//  access_token
    private String tok;
//  客户端类型  WEB端填 1
    private String ctp;
//  用户唯一标识,用来区分用户,填写MAC
    private String cuid;
//  语速，取值0-9，默认为5中语速
    private String spd;
//  音调，取值0-9，默认为5中语调
    private String pit;
//  音量，取值0-9，默认为5中音量
    private String vol;
//  发音人选择, 0为女声，1为男声，3为情感合成-度逍遥，4为情感合成-度丫丫，默认为普通女声
    private String per;

    private static String default_tok = "24.1acd699f9dc8968ba5692fae5aa54db6.2592000.1492670062.282335-9362314";
    private static String default_lan ="zh";
    private static String default_ctp = "1";
    private static String default_cuid ="1234qwer1324qwer";
    private static String default_spd = "5";
    private static String default_pit = "5";
    private static String default_vol = "5";
    private static String default_per = "3";

    public TsnParams() {

    }

    public TsnParams(String tex) {
        this.tex = tex;
        this.lan = default_lan;
        this.tok = default_tok;
        this.ctp = default_ctp;
        this.cuid = default_cuid;
        this.spd = default_spd;
        this.pit = default_pit;
        this.vol = default_vol;
        this.per = default_per;

    }

    public TsnParams(String lan, String tok, String ctp, String cuid, String spd, String pit, String vol, String per) {
        this.lan = lan;
        this.tok = tok;
        this.ctp = ctp;
        this.cuid = cuid;
        this.spd = spd;
        this.pit = pit;
        this.vol = vol;
        this.per = per;
    }

    @Override
    public String toString() {
        return "TsnParams{" +
                "tex: '" + tex + '\'' +
                ", lan: '" + lan + '\'' +
                ", tok: '" + tok + '\'' +
                ", ctp: '" + ctp + '\'' +
                ", cuid: '" + cuid + '\'' +
                ", spd: '" + spd + '\'' +
                ", pit: '" + pit + '\'' +
                ", vol: '" + vol + '\'' +
                ", per: '" + per + '\'' +
                '}';
    }

    public String getTex() {
        return tex;
    }
    public void setTex(String tex) {
        this.tex = tex;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public String getTok() {
        return tok;
    }

    public void setTok(String tok) {
        this.tok = tok;
    }

    public String getCtp() {
        return ctp;
    }

    public void setCtp(String ctp) {
        this.ctp = ctp;
    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public String getSpd() {
        return spd;
    }

    public void setSpd(String spd) {
        this.spd = spd;
    }

    public String getPit() {
        return pit;
    }

    public void setPit(String pit) {
        this.pit = pit;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }
}
