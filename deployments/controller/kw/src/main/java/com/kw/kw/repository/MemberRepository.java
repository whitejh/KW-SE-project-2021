package com.kw.kw.repository;

import com.kw.kw.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "select * from member m where m.member_id= :member_id", nativeQuery = true)
    Optional<Member> findByMemberId(@Param("member_id") String MemberId);
}
