package com.kw.kw.dto;

import com.kw.kw.entity.Goods;
import com.kw.kw.entity.Member;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PurchaseHistoryDto implements Serializable {
    @ApiModelProperty(notes = "구매 후기", required = false, example = "구매 후기 내용")
    private String content;
    @ApiModelProperty(notes = "상품의 평점", required = true, example = "3")
    private Long rating;
    @ApiModelProperty(notes = "상품을 구매할 멤버의 ID", required = true, example = "AAA@kw.ac.kr")
    private String memberId;
    @ApiModelProperty(notes = "상품의 ID", required = true, example = "2")
    private Long goodsId;
}
