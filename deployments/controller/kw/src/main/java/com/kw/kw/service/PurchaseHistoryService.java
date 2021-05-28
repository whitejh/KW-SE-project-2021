package com.kw.kw.service;

import com.kw.kw.dto.PurchaseHistoryDto;
import com.kw.kw.entity.PurchaseHistory;

import java.util.List;

public interface PurchaseHistoryService {
    List<PurchaseHistoryDto> lookupHistoryByMemberId(Long memberId);
    default PurchaseHistory dtoToEntity(PurchaseHistoryDto dto){
        PurchaseHistory entity = PurchaseHistory.builder()
                .id(dto.getId())
                .content(dto.getContent())
                .rating(dto.getRating())
                .build();
        return entity;
    }
    default PurchaseHistoryDto entityToDto(PurchaseHistory entity) {
        PurchaseHistoryDto dto = PurchaseHistoryDto.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .rating(entity.getRating())
                .build();
        return dto;
    }
}
