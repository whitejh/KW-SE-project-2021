package com.kw.kw.repository;

import com.kw.kw.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    @Query(value = "select m from Member m where m.id= :member_id")
    Optional<Member> findByMemberId(@Param("member_id") String MemberId);
}
