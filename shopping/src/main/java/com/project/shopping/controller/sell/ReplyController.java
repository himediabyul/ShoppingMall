package com.project.shopping.controller.sell;

import com.project.shopping.domain.sell.ReplyDTO;
import com.project.shopping.entity.Reply;
import com.project.shopping.service.sell.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    // sidx로 받기
    @GetMapping(value = "/{sidx}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reply> replyList(@PathVariable("sidx") int sidx){

        List<Reply> list = replyService.allList(sidx);

        return list;
    }

    // post /reply => reply    JSON 데이터를 받아서 DB insert
    @PostMapping
    public ResponseEntity<Reply> insertReply(@RequestBody ReplyDTO replyDTO){

        Reply result = replyService.insert(replyDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    // put -> 수정
    @PutMapping("/{rno}")
    public ResponseEntity<Integer> editReply(@RequestBody ReplyDTO replyDTO, @PathVariable("rno") int rno){

        replyDTO.setRno(rno);

        return new ResponseEntity<>(replyService.update(replyDTO),HttpStatus.OK);
    }
    // 삭제
    @DeleteMapping("/{rno}")
    public ResponseEntity<Integer> deleteReply(@PathVariable("rno") int rno){

        return new ResponseEntity<>(replyService.delete(rno),HttpStatus.OK);
    }

}
