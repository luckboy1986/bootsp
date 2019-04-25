package com.zhaomlb.club.bootsp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:myconfig.properties"},ignoreResourceNotFound = false,
        encoding = "UTF-8", name = "myconfig.properties")
@ConfigurationProperties(prefix = "myconfig")
public class Myconfig {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Myconfig{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
