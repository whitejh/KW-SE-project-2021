package com.kw.kw.dto;

import com.kw.kw.entity.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto implements Serializable{
    @ApiModelProperty(notes = "멤버의 ID")
    private Long id;
    @ApiModelProperty(notes = "멤버의 이름")
    private String member_id;
    @ApiModelProperty(notes = "멤버의 비밀번호")
    private String password;
    @ApiModelProperty(notes = "멤버의 전화번호")
    private String phone_number;
    @ApiModelProperty(notes = "멤버의 보유 포인트")
    private Long point;
    @ApiModelProperty(notes = "멤버의 주소")
    private String address;
    @ApiModelProperty(notes = "멤버의 차단 여부")
    private Boolean BlockStatus;
    @ApiModelProperty(notes = "멤버의 역할")
    private Role role;
}
