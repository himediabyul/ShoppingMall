package com.project.shopping.domain.member;

import com.project.shopping.entity.Member;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberEditRequest {

    private Integer uidx;

    private String uid;

    private String password;

    private String username;

    private String address1;

    private String address2;

    private String address3;

    private String extra;

    private String role;


    public Member toMemberEdit(){
        return Member.builder()
                .uidx(uidx)
                .uid(uid)
                .password(password)
                .username(username)
                .address1(address1)
                .address2(address2)
                .address3(address3)
                .extra(extra)
                .role(role)
                .build();
    }

}
