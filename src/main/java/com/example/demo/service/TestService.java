package com.example.demo.service;

import com.example.demo.dto.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String myName(String name) {
        if (name != null) {
            return "my name is " + name;
        } else {
            return "name param is null";
        }
    }

    public String myAge(Integer age) {
        if (age != null) {
            return "my age is " + age;
        } else {
            return "age param is null";
        }
    }

    public String myRole(String role) {
        if (role != null) {
            return "my role is " + role;
        } else {
            return "role param is null";
        }
    }

    public String myInfo(UserInfo userInfoDto){
        userInfoDto.setName("test");
        return myName("name : " + userInfoDto.getName()) + "\nage : " + myAge(userInfoDto.getAge()) + "\nrole : " + myRole(userInfoDto.getRole());
    }

    public String myInfoWithaddress(String address, UserInfo userInfoDto){
        return myInfo(userInfoDto) + "\naddress : " + address;
    }
}