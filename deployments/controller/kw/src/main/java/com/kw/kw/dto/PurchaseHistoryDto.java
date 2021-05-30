package com.kw.kw.dto;

import com.kw.kw.entity.Goods;
import com.kw.kw.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseHistoryDto {
    private String content;
    private Long rating;
    private Long memberId;
    private Long goodsId;
}
