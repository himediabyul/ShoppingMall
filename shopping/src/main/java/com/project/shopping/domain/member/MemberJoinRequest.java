package com.project.shopping.domain.member;

import com.project.shopping.entity.Member;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberJoinRequest {

    private Integer uidx;  // 회원번호


    private String uid;  // 회원아이디


    private String pw;  // 비밀번호

    private String name;  // 이름

    private String email;  // 이메일


    private String address1;  // 주소 (우편번호)


    private String address2;  // 주소 (검색주소)


    private String address3;  // 주소 (상세주소)


    private String role;   // USER로 고정 INSERT


    public Member toMemberEntity(){

        return Member.builder()
                .uid(uid)
                .pw(pw)
                .name(name)
                .email(email)
                .address1(address1)
                .address2(address2)
                .address3(address3)
                .role(role)
                .build();
    }

}
