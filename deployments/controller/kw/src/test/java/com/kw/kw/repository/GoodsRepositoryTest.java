package com.kw.kw.repository;

import com.kw.kw.entity.Goods;
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

    @Test
    public void testGoods(){
        //given
        Goods goods = Goods.builder().name("AAA").view_count(0L).price(100L).description("설명").build();
        //when
        goodsRepository.save(goods);
        //then
        Optional<Goods> findGoods = goodsRepository.findById(goods.getId());
        Assertions.assertThat(findGoods.get().getId()).isEqualTo(goods.getId());
        System.out.println(goods.getRegDate());
    }

    @Test
    public void basicCRUD(){
        Goods goods1 = Goods.builder().name("goods1").view_count(0L).price(100L).description("설명").build();
        Goods goods2 = Goods.builder().name("goods2").view_count(0L).price(100L).description("설명").build();
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
        goodsRepository.deleteById(goods1.getId());
        goodsRepository.deleteById(goods2.getId());
        Assertions.assertThat(goodsRepository.count()).isEqualTo(0);
    }

    @Test
    public void testFindName(){
        //given
        for(int i = 0; i < 10; i++){
            Goods goods = Goods.builder().name("A" + (i % 5)).price(100L).description("설명").view_count(0L).build();
            goodsRepository.save(goods);
        }
        //when
        List<Goods> findGoods = goodsRepository.findByName("A" + 0L);
        //then
        for(Goods goods : findGoods){
            Assertions.assertThat(goods.getName()).isEqualTo("A" + 0L);
        }
    }
}
