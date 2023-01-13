package com.project.shopping.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
    private String pw;  // 비밀번호

    @Column
    @NotEmpty
    private String name;  // 이름

    @Column
    @NotEmpty
    private String email;  // 이메일

    @Column
    @NotEmpty
    private String address1;  // 주소 (우편번호)

    @Column
    @NotEmpty
    private String address2;  // 주소 (검색주소)

    @Column
    @NotEmpty
    private String address3;  // 주소 (상세주소)

    @Column(updatable = false)
    private String role;   // USER로 고정 INSERT


}

