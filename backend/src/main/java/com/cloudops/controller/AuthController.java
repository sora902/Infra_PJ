// AuthController.java - REST 컨트롤러
package com.cloudops.controller;

import com.cloudops.model.User;
import com.cloudops.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        return userService.register(user);
    }
    
    @PostMapping("/login")  
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");
        return userService.login(email, password);
    }
    
    @GetMapping("/health")
    public String health() {
        return "Tomcat WAS is running!";
    }
}
