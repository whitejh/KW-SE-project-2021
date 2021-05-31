package com.kw.kw.entity;

import com.kw.kw.dto.GoodsDto;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name="goods")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class Goods extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = true)
    @NotNull
    private Member member;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Long price;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "view_count", nullable = false)
    @ColumnDefault("0")
    private Long view_count;

    @Column(name = "image", nullable = true)
    private String imagePath;

    public void update(GoodsDto dto, Long view_count){
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.view_count = view_count;
        this.description = dto.getDescription();
        this.imagePath = dto.getImagePath();
    }
    public void changeSeller(Member member){
        this.member = member;
    }
}
