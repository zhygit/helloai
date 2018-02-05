package com.zhytech.helloai.Talking.Beans;

import com.zhytech.helloai.Talking.HumanAction;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class Human {
    private String name;
    private String gender;
    private String age;

    public HumanAction humanAction;

    public Human() {
    }

    public Human(String name) {
        this.name = name;
        humanAction = new HumanAction();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
