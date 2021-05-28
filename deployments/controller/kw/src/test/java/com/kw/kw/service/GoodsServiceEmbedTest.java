package com.kw.kw.service;

import com.kw.kw.dto.GoodsDto;
import com.kw.kw.entity.Goods;
import com.kw.kw.repository.GoodsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class GoodsServiceEmbedTest {
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private GoodsServiceImpl goodsService;

    @Test
    @Transactional
    public void test_조회수_검증()
    {
        //given
        GoodsDto saveDto = GoodsDto.builder()
                .id(1L)
                .name("AAA")
                .price(1L)
                .description("AAA")
                .view_count(0L).build();
        goodsService.register(saveDto);
        //when
        goodsService.lookup(saveDto.getId());
        //then
        Goods findGoods = goodsRepository.findById(saveDto.getId()).get();
        Assertions.assertEquals(saveDto.getView_count() + 1, findGoods.getView_count());
    }
}
