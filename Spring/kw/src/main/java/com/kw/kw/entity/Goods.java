package com.kw.kw.entity;

import com.kw.kw.dto.GoodsDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="goods")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Goods extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String name;

    private Long price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "view_count")
    private Long view_count;


    public void update(GoodsDto dto){
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.view_count = dto.getView_count();
        this.description = dto.getDescription();
    }
}
