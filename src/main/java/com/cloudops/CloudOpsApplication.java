// CloudOpsApplication.java - 톰캣 배포용 메인 클래스
package com.cloudops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CloudOpsApplication extends SpringBootServletInitializer {
    
    // 외부 톰캣 배포를 위한 설정
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CloudOpsApplication.class);
    }
    
    // 내장 톰캣으로도 실행 가능
    public static void main(String[] args) {
        SpringApplication.run(CloudOpsApplication.class, args);
    }
}