package com.kw.kw.repository;

import com.kw.kw.entity.Member;
import com.kw.kw.entity.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void test_멤버_등록(){
        System.out.println("-----test_멤버_등록--------");
        //given
        Member member = Member.builder()
                .member_id("AAA")
                .phone_number("010-1234-5678")
                .point(100L)
                .hashed_pw("q1w2e3r4")
                .address("AAA")
                .role(Role.BUYER)
                .BlockStatus(false).build();

        //when
        memberRepository.save(member);
        //then
        List<Member> findMembers = memberRepository.findAll();
        Assertions.assertEquals(findMembers.size(), 1);
        Assertions.assertEquals(member.getPhone_number(), findMembers.get(0).getPhone_number());
    }
}
