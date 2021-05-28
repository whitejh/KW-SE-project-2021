package com.kw.kw.entity;

import com.kw.kw.dto.GoodsDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Blob;

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

    @Column(columnDefinition = "TEXT", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Long price;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "view_count", nullable = false)
    @ColumnDefault("0")
    private Long view_count;

    @Lob
    @Column(name="image_blob")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image_blob;

    public void update(GoodsDto dto, Long view_count){
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.view_count = view_count;
        this.description = dto.getDescription();
        this.image_blob = dto.getImage();
    }
}
