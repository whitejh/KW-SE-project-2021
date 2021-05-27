package com.kw.kw.service;

import com.kw.kw.dto.MemberDto;
import com.kw.kw.entity.Member;

public interface MemberService {
    String register(MemberDto dto);
    String updateById(String id, MemberDto dto);
    default Member dtoToEntity(MemberDto dto){
        Member entity = Member.builder()
                .id(dto.getId())
                .password(dto.getPassword())
                .address(dto.getAddress())
                .BlockStatus(dto.getBlockStatus())
                .phone_number(dto.getPhone_number())
                .point(dto.getPoint())
                .build();
        return entity;
    }
    default MemberDto EntityToDto(Member entity){
        MemberDto dto = MemberDto.builder()
                .id(entity.getId())
                .password(entity.getPassword())
                .address(entity.getAddress())
                .BlockStatus(entity.getBlockStatus())
                .phone_number(entity.getPhone_number())
                .point(entity.getPoint())
                .build();
        return dto;
    }
}