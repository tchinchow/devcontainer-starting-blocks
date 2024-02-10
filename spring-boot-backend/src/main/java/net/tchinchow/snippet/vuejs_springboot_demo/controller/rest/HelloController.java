package net.tchinchow.snippet.vuejs_springboot_demo.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    @RequestMapping(path = "/api/public/hello", method=RequestMethod.GET)
    public String requestMethodName(@RequestParam(name = "username", defaultValue = "${api.welcome.default_username}") String username) {
        return "Hello '" + username + "': You are talking to Spring Boot !";
    }
}