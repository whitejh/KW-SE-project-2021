package com.kw.kw.repository;

import com.kw.kw.entity.Category;
import com.kw.kw.entity.Goods;
import com.kw.kw.entity.GoodsCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
public class GoodsCategoryRepositoryTest {
    @Autowired
    GoodsCategoryRepository goodsCategoryRepository;
    @Autowired
    GoodsRepository goodsRepository;
    @Test
    public void test_카테고리_등록(){
        /*Goods goods = Goods.builder()
                .name("AAA")
                .description("AAA")
                .price(10L)
                .view_count(0L).build();
        GoodsCategory goodsCategory = GoodsCategory.builder()
                .goods(goods)
                .category(new Category[] {Category.COMPUTER, Category.HOME_APPLIANCE}).build();
        goodsCategoryRepository.save(goodsCategory);
        GoodsCategory findGoodsCategory = goodsCategoryRepository.findById(goods.getId()).get();
        Assertions.assertEquals(findGoodsCategory.getCategory().length, 2);*/
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
