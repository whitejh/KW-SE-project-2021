package com.kw.kw.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GoodsDto {
    @ApiModelProperty(notes = "상품의 ID")
    private Long id;
    @ApiModelProperty(notes = "상품의 이름")
    private String name;
    @ApiModelProperty(notes = "상품의 가격")
    private Long price;
    @ApiModelProperty(notes = "유저의 설명")
    private String description;
    @ApiModelProperty(notes = "조회수")
    private Long view_count; //입력으로 들어오지는 않지만, 보내주어야 하는 데이터
    @ApiModelProperty(notes = "상품의 이미지")
    private byte[] image;
}
