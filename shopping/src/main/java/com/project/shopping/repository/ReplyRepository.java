package com.project.shopping.repository;

import com.project.shopping.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    @Query("select r from Reply r where r.sidx = :sidx order by r.rno")
    List<Reply> findBySidx(@Param("sidx") Integer sidx);

    @Transactional
    @Modifying
    @Query("delete from Reply r where r.rno = :rno")
    int deleteByRno(Integer rno);


    // 게시글 삭제 시 -> 모든 댓글이 삭제 되어야 게시글이 삭제!
    // 해당 게시물의 모든 댓글을 삭제하는 메소드
    @Transactional
    @Modifying
    @Query("delete from Reply r where r.sidx = ?1")
    int deleteBySidx(Integer sidx);


}
