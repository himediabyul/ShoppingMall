package com.project.shopping.service.sell;

import com.project.shopping.domain.sell.ReplyDTO;
import com.project.shopping.entity.Reply;
import com.project.shopping.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    // 댓글 등록
    public Reply insert(ReplyDTO replyDTO){

        Reply reply = replyDTO.toReplyEntity();

        reply.setReplydate(LocalDate.now());
        reply.setUpdatedate(LocalDate.now());

        return replyRepository.save(reply);
    }

    // 댓글 리스트
    public List<Reply> allList(int sidx){

        return replyRepository.findBySidx(sidx);
    }

    // 댓글 수정
    public int update(ReplyDTO replyDTO){

        Reply reply = replyDTO.toReplyEntity();

        reply.setUpdatedate(LocalDate.now());
        reply.setReplydate(LocalDate.parse(replyDTO.getReplydate()));  // 댓글 작성일은 dto에서 받아옴

        return replyRepository.save(reply) != null ? 1 : 0;

    }

    // 댓글 삭제
    public int delete(int rno){

        return replyRepository.deleteByRno(rno);
    }

}
