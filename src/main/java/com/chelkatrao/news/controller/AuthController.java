package com.chelkatrao.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @GetMapping({"/login", ""})
    public String auth() {
        return "login";
    }

    @GetMapping("/bad")
    public String bed() {
        return "bad";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
