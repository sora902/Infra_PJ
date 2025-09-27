// UserService.java - 간단한 사용자 서비스
package com.cloudops.service;

import com.cloudops.model.User;
import com.cloudops.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; - 비밀번호 암호화시 주석 해제
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, Object> register(User user) {
        Map<String, Object> result = new HashMap<>();

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            result.put("success", false);
            result.put("message", "이미 존재하는 이메일입니다.");
            return result;
        }

        userRepository.save(user);

        result.put("success", true);
        result.put("message", "회원가입이 완료되었습니다.");
        result.put("user", user);
        return result;
    }

    public Map<String, Object> login(String email, String password) {
        Map<String, Object> result = new HashMap<>();

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            result.put("success", false);
            result.put("message", "존재하지 않는 사용자입니다.");
            return result;
        }

        User user = optionalUser.get();

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
