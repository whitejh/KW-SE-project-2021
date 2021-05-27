package com.kw.kw.service;

import com.kw.kw.dto.MemberDto;
import com.kw.kw.entity.Member;
import com.kw.kw.repository.MemberRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    private MemberServiceImpl memberService;
    @Autowired
    private MemberRepository memberRepository;
    @Test
    public void test_멤버등록(){
        //given
        MemberDto member1 = MemberDto.builder()
                .id("yun")
                .address("AAA")
                .BlockStatus(false)
                .password("AAA")
                .phone_number("010-1234-5678")
                .build();
        MemberDto member2 = MemberDto.builder()
                .id("yun")
                .address("AAA")
                .BlockStatus(false)
                .password("AAA")
                .phone_number("010-1234-5678")
                .build();
        //단건 등록 검증
        memberService.register(member1);
        List<Member> findMember = memberRepository.findAll();
        Assertions.assertEquals(findMember.size(), 1);
    }
}
