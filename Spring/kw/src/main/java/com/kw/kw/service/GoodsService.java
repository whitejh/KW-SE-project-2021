package com.kw.kw.service;

import com.kw.kw.dto.GoodsDto;
import com.kw.kw.entity.Goods;

public interface GoodsService {
    Long register(GoodsDto dto);

    default Goods dtoToEntity(GoodsDto dto){
        Goods entity = Goods.builder()
                .id(dto.getId())
                .price(dto.getPrice())
                .name(dto.getName())
                .description(dto.getDescription())
                .view_count(dto.getView_count())
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
                .build();
        return dto;
    }
}
