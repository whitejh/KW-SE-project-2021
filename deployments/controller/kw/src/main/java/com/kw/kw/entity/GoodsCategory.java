package com.kw.kw.entity;

import com.kw.kw.custom.PostgreSQLEnumType;
import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.*;
import com.vladmihalcea.hibernate.type.array.EnumArrayType;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
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
    @EmbeddedId
    protected GoodsCategoryPK goodsCategoryPK;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,orphanRemoval = true)
    @JoinColumn(name = "goods_id", insertable = false, updatable = false)
    protected Goods goods;
}
