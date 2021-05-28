package com.kw.kw.service;

import com.kw.kw.dto.GoodsDto;
import com.kw.kw.entity.Goods;
import com.kw.kw.repository.GoodsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.BDDMockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class GoodsServiceMockTest {
    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Spy
    private GoodsRepository goodsRepository;
    @InjectMocks
    private GoodsServiceImpl goodsServiceImpl;

    @Test
    public void testRegister()
    {
        //given
        GoodsDto goodsDto = createGoodsDto();
        given(goodsRepository.save(any(Goods.class)))
                .willReturn(createGoods(goodsDto));
        //when
        goodsServiceImpl.register(goodsDto);

        //then
        verify(goodsRepository, atLeastOnce()).save(any(Goods.class)); //save가 적어도 한 번 호출되는지 검증
    }

    private GoodsDto createGoodsDto(){
        return GoodsDto.builder()
                .id(1L)
                .name("TEST")
                .price(1L)
                .description("TEST")
                .view_count(1L)
                .build();
    }

    private Goods createGoods(GoodsDto dto){
        Goods goods = Goods.builder()
                .name("TEST")
                .price(1L)
                .description("TEST")
                .view_count(1L)
                .build();
        ReflectionTestUtils.setField(goods, "id", 1L);
        return goods;
    }
    private Goods createGoods()
    {
        return Goods.builder()
                .id(1L)
                .name("TEST")
                .description("TEST")
                .price(1L)
                .view_count(1L).build();
    }
}
