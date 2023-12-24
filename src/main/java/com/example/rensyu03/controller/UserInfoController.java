package com.example.rensyu03.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapi")
public class UserInfoController {
    private static  final Logger log = LoggerFactory.getLogger(UserInfoController.class);
    @GetMapping("/userinfo")
    public String getUserInfo() {
        // ログで”開始"を出力
        log.info("開始します。");
        return "User information";
    }
}
