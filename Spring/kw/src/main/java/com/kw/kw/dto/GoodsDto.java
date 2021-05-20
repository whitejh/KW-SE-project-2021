package com.kw.kw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GoodsDto {
    private Long id;
    private String name;
    private Long price;
    private String description;
    private Long view_count; //입력으로 들어오지는 않지만, 보내주어야 하는 데이터
    private byte[] image;
}
