package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("test") // 리소스
public class TestController {

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id)
    {
        return "Hello World! ID " + id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id) {
        return "Hello World! ID " + id;
    }

    @GetMapping("/testRequestBody")
    public ResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseDTO");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you got 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // http status를  400으로 설정
        return ResponseEntity.badRequest().body(response);

    }
}