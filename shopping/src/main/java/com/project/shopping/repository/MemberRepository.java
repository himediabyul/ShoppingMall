package com.project.shopping.repository;

import com.project.shopping.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByUid(String username);

    Optional<Member> findByUidx(Integer uidx);

    @Transactional
    @Modifying
    @Query("delete from Member m where m.uidx = :uidx")
    int deleteByUidx(@Param("uidx") Integer uidx);


    boolean existsByUid(String uid);



}


