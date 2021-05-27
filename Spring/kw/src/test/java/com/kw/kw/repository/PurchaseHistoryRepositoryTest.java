package com.kw.kw.repository;

import com.kw.kw.entity.Goods;
import com.kw.kw.entity.Member;
import com.kw.kw.entity.PurchaseHistory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class PurchaseHistoryRepositoryTest {
    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Test
    public void test_구매내역_등록(){
        //given
        Member member = Member.builder()
                .id("yun")
                .phone_number("010-1234-5678")
                .point(100L)
                .password("q1w2e3r4")
                .address("AAA")
                .BlockStatus(false).build();
        memberRepository.save(member);
        Goods goods = Goods.builder().price(100L)
                .view_count(0L)
                .description("AAA")
                .name("AAA")
                .build();
        goodsRepository.save(goods);
        PurchaseHistory purchaseHistory = PurchaseHistory.builder()
                .member(member)
                .goods(goods)
                .rating(3L)
                .content("test").build();
        //when
        System.out.println("------test_구매내역_등록------");
        purchaseHistoryRepository.saveAndFlush(purchaseHistory);
        //then
        List<PurchaseHistory> findPurchases = purchaseHistoryRepository.findAll();
        Assertions.assertEquals(findPurchases.size(), 1);
    }
}
