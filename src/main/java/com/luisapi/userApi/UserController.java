package com.luisapi.userApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(path = "/hello")
    public String index(){
        return "Hello asdfasdfasdf";
    }
}
