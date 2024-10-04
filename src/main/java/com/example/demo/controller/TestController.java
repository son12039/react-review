package com.example.demo.controller;

import com.example.demo.dto.UserInfo;
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

    @PutMapping("/info")
    ResponseEntity<?> putHelloWorld(@RequestBody UserInfo userInfoDto){
        return new ResponseEntity<>(testService.myInfo(userInfoDto),HttpStatus.OK);
    }
    @DeleteMapping("/name")
    ResponseEntity<?> deleteHelloWorld(@RequestHeader(name="address") String address, @RequestBody UserInfo userInfoDto){
        return new ResponseEntity<>(testService.myInfoWithaddress(address, userInfoDto),HttpStatus.OK);
    }
}