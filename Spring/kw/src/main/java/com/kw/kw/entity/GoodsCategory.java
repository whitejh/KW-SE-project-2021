package com.kw.kw.entity;

import com.kw.kw.custom.PostgreSQLEnumType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.*;
import com.vladmihalcea.hibernate.type.array.EnumArrayType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
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
    private Category category;
}
