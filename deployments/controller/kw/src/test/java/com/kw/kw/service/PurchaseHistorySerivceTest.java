package com.kw.kw.service;

import com.kw.kw.dto.PurchaseHistoryDto;
import com.kw.kw.entity.Goods;
import com.kw.kw.entity.Member;
import com.kw.kw.entity.PurchaseHistory;
import com.kw.kw.entity.Role;
import com.kw.kw.repository.GoodsRepository;
import com.kw.kw.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class PurchaseHistorySerivceTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private PurchaseHistoryServiceImpl purchaseHistoryService;

    @Test
    public void test_구매내역_등록(){
        //given
        Member member = createMember();
        memberRepository.saveAndFlush(member);
        Goods goods = createGoods();
        goodsRepository.saveAndFlush(goods);
        PurchaseHistoryDto purchaseHistoryDto = PurchaseHistoryDto.builder()
                .goodsId(goods.getId())
                .memberId(member.getId())
                .content("Test")
                .rating(5L).build();
        //when
        Long registerId = purchaseHistoryService.buyGoods(purchaseHistoryDto);
        //then
        List<PurchaseHistoryDto> findDto = purchaseHistoryService.lookupHistoryByMemberId(member.getId());
        Assertions.assertEquals(findDto.size(), 1);
        Assertions.assertEquals(findDto.get(0).getContent(), "Test");
    }
    public Member createMember(){
        Member member = Member.builder()
                .id("홍길동")
                .phone_number("010-1234-5678")
                .point(100L)
                .address("경기도 의정부시")
                .role(Role.BUYER)
                .BlockStatus(false).build();
        return member;
    }
    public Goods createGoods(){
        Goods goods = Goods.builder().price(100L)
                .view_count(0L)
                .description("지지직")
                .name("드라이기")
                .build();
        return goods;
    }
}
