package com.project.shopping.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uidx;  // 회원번호

    @Column
    @NotEmpty
    private String uid;  // 회원아이디

    @Column
    @NotEmpty
    private String password;  // 비밀번호

    @Column
    @NotBlank
    private String username;  // 이름

    @Column
    @NotEmpty
    private String phone;  // 전화번호

    @Column
    @NotEmpty
    private String address1;  // 주소 (우편번호)

    @Column
    @NotEmpty
    private String address2;  // 주소 (검색주소)

    @Column
    @NotEmpty
    private String address3;  // 주소 (상세주소)

    @Column
    private String extra;  // 주소지 참고사항

    @Column(updatable = false)
    private String role;   // USER로 고정 INSERT

    @Column
    private LocalDate joindate; // 가입일

    }



