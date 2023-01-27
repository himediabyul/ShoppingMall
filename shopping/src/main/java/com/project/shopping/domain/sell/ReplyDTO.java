package com.project.shopping.domain.sell;

import com.project.shopping.entity.Member;
import com.project.shopping.entity.Reply;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReplyDTO {

    private int rno;

    private int sidx;

    private String reply;

    private Integer replyer;  // String -> int

    private String replydate;

    private String updatedate;

    public Reply toReplyEntity(){
        return Reply.builder()
                .rno(rno)
                .sidx(sidx)
                .reply(reply)
                .replyer(Member.builder().uidx(replyer).build())
                .build();
    }


}
