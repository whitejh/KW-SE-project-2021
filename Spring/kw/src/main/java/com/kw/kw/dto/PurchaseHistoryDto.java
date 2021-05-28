package com.kw.kw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseHistoryDto {
    private Long id;
    private String content;
    private Long rating;
}
