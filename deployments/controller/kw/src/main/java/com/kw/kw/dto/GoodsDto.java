package com.kw.kw.dto;

import com.kw.kw.entity.Category;
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
public class GoodsDto implements Serializable {
    @ApiModelProperty(notes = "상품의 ID", required = false)
    private Long id;
    @ApiModelProperty(notes = "상품의 이름", required = true)
    private String name;
    @ApiModelProperty(notes = "올린 유저의 ID", required = true)
    private String sellerId;
    @ApiModelProperty(notes = "상품의 가격", required = true)
    private Long price;
    @ApiModelProperty(notes = "유저의 설명", required = true)
    private String description;
    @ApiModelProperty(notes = "조회수")
    private Long view_count; //입력으로 들어오지는 않지만, 보내주어야 하는 데이터
    @ApiModelProperty(notes = "상품의 이미지 경로", required = false)
    private String imagePath;
    @ApiModelProperty(notes = "상품의 카테고리", required = true)
    private Category category;
}
