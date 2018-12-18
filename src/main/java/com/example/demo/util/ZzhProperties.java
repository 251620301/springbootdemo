package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ZzhProperties {
    @Value("${com.example.demo.title}")
    private String title;
    @Value("${com.example.demo.description}")
    private String description;
}
