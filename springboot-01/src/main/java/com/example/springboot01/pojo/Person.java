package com.example.springboot01.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 人
 * @author hsy
 */
//使用配置文件的配置注入数据
//@PropertySource("classpath:hsy.properties")
@Component
@ConfigurationProperties(prefix = "person")
@Data
//JSR303检验 --@Validated
public class Person {
    //@Value("${name}")
    //@Email
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> map;
    private List<Object> lists;
    private Dog dog;
}
