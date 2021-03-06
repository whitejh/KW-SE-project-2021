package com.kw.kw.repository;

import com.kw.kw.entity.Goods;
import com.kw.kw.entity.Member;
import com.kw.kw.entity.PurchaseHistory;
import com.kw.kw.entity.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class PurchaseHistoryRepositoryTest {
    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Test
    public void test_구매내역_등록(){
        String memberName = "홍길동";
        String goodsName = "드라이기";
        //given
        Member member = Member.builder()
                .id(memberName)
                .phone_number("010-1234-5678")
                .point(100L)
                .address("경기도 의정부시")
                .role(Role.BUYER)
                .BlockStatus(false).build();
        memberRepository.saveAndFlush(member);
        Goods goods = Goods.builder().price(100L)
                .view_count(0L)
                .description("지지직")
                .name(goodsName)
                .build();
        goodsRepository.saveAndFlush(goods);
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
        Assertions.assertEquals(findPurchases.get(0).getMember().getId(), memberName);
        Assertions.assertEquals(findPurchases.get(0).getGoods().getName(), goodsName);
    }
    @Test
    public void test_구매내역_조회(){
        int size = 3;
        //given
        Member member = Member.builder()
                .id("AAA")
                .phone_number("010-1234-5678")
                .point(100L)
                .address("AAA")
                .role(Role.BUYER)
                .BlockStatus(false).build();
        memberRepository.save(member);
        for(int i = 0; i < size; i++){
            Goods goods = Goods.builder().price(100L)
                    .view_count(0L)
                    .description("AAA" + i)
                    .name("AAA" + i)
                    .build();
            goodsRepository.save(goods);
            PurchaseHistory purchaseHistory = PurchaseHistory.builder()
                    .member(member)
                    .goods(goods)
                    .rating(3L)
                    .content("test").build();
            purchaseHistoryRepository.saveAndFlush(purchaseHistory);
        }
        System.out.println("------test_구매내역_등록------");
        //when
        List<PurchaseHistory> findHistorys = purchaseHistoryRepository.findPurchaseHistoryByMemberId(member.getId());
        //then
        Assertions.assertEquals(findHistorys.size(), size);
    }
}
