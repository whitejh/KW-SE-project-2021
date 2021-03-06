package com.kw.kw.service;

import com.kw.kw.dto.MemberDto;
import com.kw.kw.entity.Member;

public interface MemberService {
    String register(MemberDto dto);
    String updateById(String id, MemberDto dto);
    MemberDto findByMemberId(String memberId);
    MemberDto findById(String id);
    default Member dtoToEntity(MemberDto dto){
        Member entity = Member.builder()
                .id(dto.getId())
                .address(dto.getAddress())
                .BlockStatus(dto.getBlockStatus())
                .phone_number(dto.getPhone_number())
                .point(dto.getPoint())
                .role(dto.getRole())
                .build();
        return entity;
    }
    default MemberDto EntityToDto(Member entity){
        MemberDto dto = MemberDto.builder()
                .id(entity.getId())
                .address(entity.getAddress())
                .BlockStatus(entity.getBlockStatus())
                .phone_number(entity.getPhone_number())
                .point(entity.getPoint())
                .role(entity.getRole())
                .build();
        return dto;
    }
}
