package com.example.rensyu03.controller;

import com.example.rensyu03.exceptions.InvalidValueException;
import com.example.rensyu03.model.value.CommonPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.server.ResponseStatusException;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/myapi")
public class ServiceOrderController {

    private static final Logger log = LoggerFactory.getLogger(ServiceOrderController.class);

    /**
     * リクエストボディの"CONTESTS"というカンマ区切りのテキストを取得する。
     * 取得した文字列をカンマ区切りで分割する。
     * 分割した文字列のバリデーションチェックを行う。
     * 問題がない場合、文字列をファイルに出力する。
     * クライアントには、リクエストボディの"CONTENTS"をそのままテキストで返す。
     */
    @PostMapping("/service-order")
    public ResponseEntity<Object> processServiceOrder(@RequestBody String body) {
        log.info("Received service order: {}", body);

        // リクエストボディに"CONTESTS"が設定されているかどうかのチェック。
        // 設定されていない場合、BAD REQUESTを返す。
        if (!body.contains("CONTENTS")) {
            return ResponseEntity.badRequest().build();
        }

        // ISO-8859-1からUTF-8への変換は、UnsupportedEncodingExceptionを投げることはありません
        byte[] contentsBytes = body.getBytes(StandardCharsets.ISO_8859_1);
        String contentsUTF8 = new String(contentsBytes, StandardCharsets.UTF_8);

        // Splitting the string into a comma-separated array
        String[] contentsArray = StringUtils.tokenizeToStringArray(contentsUTF8, ",");

        try {
            CommonPart commonPart = CommonPart.createInstance(contentsArray);
        } catch (InvalidValueException e) {
            log.error("Invalid value exception occurred: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }






        // Contents processed as per your requirement
        StringBuilder contentsProcessed = new StringBuilder();
        for (String value : contentsArray) {
            contentsProcessed.append(value);
            // Add other processing here...
        }

        // Conversion from UTF-8 to Shift-JIS for the response
        String response = null;
        try {
            response = new String(contentsProcessed.toString().getBytes(StandardCharsets.UTF_8), "Shift-JIS");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "plain", Charset.forName("Shift-JIS")));

        return ResponseEntity.ok().headers(headers).body(response);
    }


}

