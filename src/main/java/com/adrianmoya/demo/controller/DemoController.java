package com.adrianmoya.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrianmoya.demo.model.ProcessResponse;

@RestController
public class DemoController {
    
    @GetMapping
    public String hello(){
        return "Hello";
    }

    @PostMapping
    public ResponseEntity<ProcessResponse> process() {
        return ResponseEntity.ok(new ProcessResponse());
    }
}
