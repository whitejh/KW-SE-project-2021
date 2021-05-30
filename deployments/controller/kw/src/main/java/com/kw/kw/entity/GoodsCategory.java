package com.kw.kw.entity;

import com.kw.kw.custom.PostgreSQLEnumType;
import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.*;
import com.vladmihalcea.hibernate.type.array.EnumArrayType;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="goods_category")
@ToString (exclude = "goods")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@TypeDef(
        name = "category",
        typeClass = PostgreSQLEnumType.class
)
public class GoodsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "goods_id")
    private Goods goods;
    @Column(name = "category", columnDefinition = "category")
    @Type(type = "category")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category;
}
