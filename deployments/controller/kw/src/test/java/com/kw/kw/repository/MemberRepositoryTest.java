package com.kw.kw.repository;

import com.kw.kw.entity.Member;
import com.kw.kw.entity.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void test_멤버_등록(){
        String memberId = "team4@kw.ac.kr";
        Role role = Role.BUYER;
        System.out.println("-----test_멤버_등록--------");
        //given
        Member member = Member.builder()
                .id(memberId)
                .phone_number("010-1234-5678")
                .address("경기도 의정부시")
                .point(10000L)
                .role(role)
                .BlockStatus(false).build();
        //when
        memberRepository.save(member);
        //then
        Member findMember = memberRepository.findByMemberId(memberId).get();
        Assertions.assertEquals(findMember.getId(), memberId);
        Assertions.assertEquals(findMember.getRole(), role);
    }
}
