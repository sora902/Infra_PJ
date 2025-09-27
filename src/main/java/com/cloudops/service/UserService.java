// UserService.java - 간단한 사용자 서비스
package com.cloudops.service;

import com.cloudops.model.User;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    
    // 메모리 저장소 (실제로는 DB 사용)
    private Map<String, User> users = new HashMap<>();
    private Long nextId = 1L;
    
    public UserService() {
        // 기본 사용자 추가
        User admin = new User("관리자", "admin@cloudops.com", "010-1234-5678", "admin123");
        admin.setId(nextId++);
        users.put(admin.getEmail(), admin);
    
    // 회원가입
    public Map<String, Object> register(User user) {
        Map<String, Object> result = new HashMap<>();
        
        if (users.containsKey(user.getEmail())) {
            result.put("success", false);
            result.put("message", "이미 존재하는 이메일입니다.");
            return result;
        }
        
        user.setId(nextId++);
        users.put(user.getEmail(), user);
        
        result.put("success", true);
        result.put("message", "회원가입이 완료되었습니다.");
        result.put("user", user);
        return result;
    }
    
    // 로그인
    public Map<String, Object> login(String email, String password) {
        Map<String, Object> result = new HashMap<>();
        
        User user = users.get(email);
        if (user == null) {
            result.put("success", false);
            result.put("message", "존재하지 않는 사용자입니다.");
            return result;
        }
        
        if (!user.getPassword().equals(password)) {
            result.put("success", false);
            result.put("message", "비밀번호가 일치하지 않습니다.");
            return result;
        }
        
        result.put("success", true);
        result.put("message", "로그인 성공");
        result.put("user", user);
        return result;
    }
}