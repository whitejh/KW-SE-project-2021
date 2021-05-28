package com.kw.kw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
    private Long id;
    private String member_id;
    private String password;
    private String phone_number;
    private Long point;
    private String address;
    private Boolean BlockStatus;
}
