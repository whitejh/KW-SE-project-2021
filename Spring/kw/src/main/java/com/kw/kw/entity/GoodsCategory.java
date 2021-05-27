package com.kw.kw.entity;

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
@TypeDefs({
      @TypeDef(
              typeClass = StringArrayType.class,
              defaultForType = String[].class
      ),
        @TypeDef(
                typeClass = EnumArrayType.class,
                defaultForType = Category[].class,
                parameters = {
                        @org.hibernate.annotations.Parameter(
                                name = EnumArrayType.SQL_ARRAY_TYPE,
                                value = "category"
                        )
                }
        )
})
public class GoodsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "goods_id")
    private Goods goods;
    @Column(name = "category",
    columnDefinition = "category[]")
    private Category[] category;
}
