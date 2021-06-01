package com.kw.kw.service;

import com.kw.kw.dto.GoodsDto;
import com.kw.kw.entity.Goods;
import com.kw.kw.entity.Member;

import java.util.List;

public interface GoodsService {
    Long register(GoodsDto dto);
    Long delete(Long id);
    Long updateById(Long id, GoodsDto dto);
    GoodsDto lookup(Long id);
    List<GoodsDto> findAllGoods();

    default Goods dtoToEntity(GoodsDto dto){
        Goods entity = Goods.builder()
                .id(dto.getId())
                .price(dto.getPrice())
                .name(dto.getName())
                .description(dto.getDescription())
                .view_count(dto.getView_count() == null ? 0 : dto.getView_count())
                .imagePath(dto.getImagePath())
                .build();
        return entity;
    }
    default Goods dtoToEntity(GoodsDto dto, Member member){
        Goods entity = Goods.builder()
                .id(dto.getId())
                .member(member)
                .price(dto.getPrice())
                .name(dto.getName())
                .description(dto.getDescription())
                .view_count(dto.getView_count() == null ? 0 : dto.getView_count())
                .imagePath(dto.getImagePath())
                .build();
        return entity;
    }

    default GoodsDto EntityToDto(Goods entity){
        GoodsDto dto = GoodsDto.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .name(entity.getName())
                .description(entity.getDescription())
                .view_count(entity.getView_count())
                .imagePath(entity.getImagePath())
                .build();
        return dto;
    }
}
