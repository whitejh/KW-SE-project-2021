package com.kw.kw.repository;

import com.kw.kw.entity.Goods;
import com.kw.kw.entity.Member;
import com.kw.kw.entity.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class GoodsRepositoryTest {
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    MemberRepository memberRepository;
    String memberId = "team4@kw.ac.kr";
    String goodsName = "드라이기";
    @Test
    public void test_상품_등록(){
        Member member = createMember();
        memberRepository.save(member);
        //given
        Goods goods = Goods.builder()
                .name(goodsName)
                .view_count(0L)
                .description("AAA")
                .price(100L)
                .image_blob(null)
                .member(member).build();
        //when
        goodsRepository.save(goods);
        //then
        Optional<Goods> findGoods = goodsRepository.findById(goods.getId());
        Assertions.assertThat(findGoods.get().getId()).isEqualTo(goods.getId());
        System.out.println(goods.getRegDate());
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

    @Test
    public void basicCRUD(){
        Member member = createMember();
        memberRepository.save(member);
        Goods goods1 = Goods.builder().member(member).name("goods1").view_count(0L).price(100L).description("설명").build();
        Goods goods2 = Goods.builder().member(member).name("goods2").view_count(0L).price(100L).description("설명").build();
        goodsRepository.save(goods1);
        goodsRepository.save(goods2);
        //단건 조회 검증
        Optional<Goods> findGoods1 = goodsRepository.findById(goods1.getId());
        Optional<Goods> findGoods2 = goodsRepository.findById(goods2.getId());
        Assertions.assertThat(findGoods1.get().getId()).isEqualTo(goods1.getId());
        Assertions.assertThat(findGoods2.get().getId()).isEqualTo(goods2.getId());

        //리스트 조회 검증
        List<Goods> findGoods = goodsRepository.findAll();
        Assertions.assertThat(findGoods.size()).isEqualTo(2);

        //삭제 검증
        goods1.changeSeller(null);
        goodsRepository.deleteById(goods1.getId());
        goods2.changeSeller(null);
        goodsRepository.deleteById(goods2.getId());
        Assertions.assertThat(goodsRepository.count()).isEqualTo(0);
    }
}
