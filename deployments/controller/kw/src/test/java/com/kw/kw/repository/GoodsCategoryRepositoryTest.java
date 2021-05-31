package com.kw.kw.repository;

import com.kw.kw.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class GoodsCategoryRepositoryTest {
    @Autowired
    GoodsCategoryRepository goodsCategoryRepository;
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    MemberRepository memberRepository;
    String memberId = "team4@kw.ac.kr";
    @Test
    public void test_카테고리_등록(){
        //given
        Member member = createMember();
        memberRepository.save(member);
        Goods goods = createGoods(member);
        goodsRepository.save(goods);
        GoodsCategoryPK goodsCategoryPK = GoodsCategoryPK.builder()
                .goodsId(goods.getId())
                .category(Category.FOO).build();
        GoodsCategory goodsCategory = GoodsCategory.builder()
                .goodsCategoryPK(goodsCategoryPK)
                .goods(goods).build();
        //when
        goodsCategoryRepository.save(goodsCategory);
        //then
        List<GoodsCategory> findCategory = goodsCategoryRepository.findAll();
        Assertions.assertEquals(1, findCategory.size());
    }
    public Member createMember(){
        return Member.builder()
                .id(memberId)
                .phone_number("010-1234-5678")
                .address("경기도 의정부시")
                .point(10000L)
                .role(Role.BUYER)
                .BlockStatus(false).build();
    }
    public Goods createGoods(Member member){
        return Goods.builder()
                .member(member)
                .view_count(0L)
                .price(100L)
                .description("AAA")
                .name("뚤딸리").build();
    }

    @Test
    public void test_상품삭제_카테고리삭제(){
        //given
        /*Goods goods = Goods.builder().name("AAA").description("AAA").price(10L).view_count(0L).build();
        GoodsCategory goodsCategory = GoodsCategory.builder().goods(goods).build();
        goodsRepository.save(goods);
        goodsCategoryRepository.save(goodsCategory);
        System.out.println("카테고리 등록 테스트 id: " + goods.getId());
        //when
        goodsRepository.deleteById(goods.getId());
        goodsRepository.flush();
        //then
        Optional<GoodsCategory> findGoodsCategory = goodsCategoryRepository.findById(goods.getId());
        System.out.println("카테고리 찾음 테스트 id: " + findGoodsCategory.get().getId());*/
    }
}
