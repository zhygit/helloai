package com.zhytech.helloai.Tuling.Beans;

import javax.lang.model.element.NestingKind;

/**
 * Created by zhy on 2017/3/23.
 */
public class Function {
    private String song;
    private String singer;

    public Function() {
    }

    @Override
    public String toString() {
        return "Function{" +
                "song: '" + song + '\'' +
                ", singer: '" + singer + '\'' +
                '}';
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
