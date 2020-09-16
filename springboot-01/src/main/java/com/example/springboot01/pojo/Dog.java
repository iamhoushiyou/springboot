package com.example.springboot01.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Dog {
    @Value("旺财")
    private String name;
    @Value("3")
    private int age;
}
