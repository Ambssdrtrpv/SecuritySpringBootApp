package ru.elchueva.springcourse.FirstSpringSecurityApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String login() {
        return "login"; // Убедитесь, что у вас есть файл login.html в папке templates
    }
}