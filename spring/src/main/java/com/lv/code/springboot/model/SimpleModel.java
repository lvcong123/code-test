package com.lv.code.springboot.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import java.util.Date;

@Data
public class SimpleModel {

    private String name;
    @Max(value = 90, message = "年龄最大不能超过90")
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    @Override
    public String toString() {
        return "SimpleModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date='" + date + '\'' +
                '}';
    }
}
