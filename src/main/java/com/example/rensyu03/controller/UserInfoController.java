package com.example.rensyu03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapi")
public class UserInfoController {
    @GetMapping("/userinfo")
    public String getUserInfo() {
        return "User information";
    }
}
