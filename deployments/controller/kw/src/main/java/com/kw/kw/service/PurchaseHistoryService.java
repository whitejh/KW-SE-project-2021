package com.kw.kw.service;

import com.kw.kw.dto.PurchaseHistoryDto;
import com.kw.kw.entity.PurchaseHistory;

import java.util.List;

public interface PurchaseHistoryService {
    List<PurchaseHistoryDto> lookupHistoryByMemberId(Long memberId);
    Long buyGoods(PurchaseHistoryDto dto);
    default PurchaseHistory dtoToEntity(PurchaseHistoryDto dto){
        PurchaseHistory entity = PurchaseHistory.builder()
                .content(dto.getContent())
                .rating(dto.getRating())
                .build();
        return entity;
    }
    default PurchaseHistoryDto entityToDto(PurchaseHistory entity) {
        PurchaseHistoryDto dto = PurchaseHistoryDto.builder()
                .content(entity.getContent())
                .rating(entity.getRating())
                .build();
        return dto;
    }
}
