package com.cloudops.model; // 현재 패키지명 그대로 유지

import javax.persistence.Entity;
import javax.persistence.GeneratedValue; // <-- 추가
import javax.persistence.GenerationType; // <-- 추가
import javax.persistence.Id;             // <-- 추가
import javax.persistence.Table;

// Lombok 어노테이션 추가 (Getter, Setter 등을 자동으로 만들어줌)
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;    // 기본 생성자
import lombok.AllArgsConstructor;   // 모든 필드 생성자

@Entity // 이 클래스를 JPA 엔티티로 지정
@Table(name = "users") // 데이터베이스의 'users' 테이블과 매핑
@Getter // Lombok: 모든 필드에 대한 getter 메서드 자동 생성
@Setter // Lombok: 모든 필드에 대한 setter 메서드 자동 생성
@NoArgsConstructor // Lombok: 인자 없는 기본 생성자 자동 생성
@AllArgsConstructor // Lombok: 모든 필드를 인자로 받는 생성자 자동 생성
public class User {

    @Id // 이 필드를 Primary Key (기본 키)로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 값을 데이터베이스가 자동으로 생성하도록 위임 (MariaDB에 적합)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String password;

    // TODO: 비밀번호 암호화를 위한 필드 추가 및 로직 적용 필요 (지금은 임시 평문 상태)


    // Lombok을 사용하여 Getter, Setter, 생성자 등을 대체하므로 수동으로 작성된 코드는 제거해도 됩니다.
    // (선택 사항: 디버깅 용이성을 위해 toString() 메서드를 추가할 수 있습니다.)
    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", phone='" + phone + '\'' +
               '}';
    }
}
