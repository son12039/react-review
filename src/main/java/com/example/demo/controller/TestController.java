package com.example.demo.controller;

import com.example.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/name")
    ResponseEntity<?> getHelloWorld(@RequestParam(name="name", required = false) String name){
        log.info(name);
        return new ResponseEntity<>(testService.myName(name), HttpStatus.OK);
    }

    @PostMapping("/age/{age}")
    ResponseEntity<?> postHelloWorld(@PathVariable("age") Integer age){
        return new ResponseEntity<>(testService.myAge(age),HttpStatus.OK);
    }

    @PutMapping("/name")
    ResponseEntity<?> putHelloWorld(){
        return new ResponseEntity<>("Hello World By Put Method",HttpStatus.OK);
    }

    @DeleteMapping("/name")
    ResponseEntity<?> deleteHelloWorld(){
        return new ResponseEntity<>("Hello World By Delete Method",HttpStatus.OK);
    }
}