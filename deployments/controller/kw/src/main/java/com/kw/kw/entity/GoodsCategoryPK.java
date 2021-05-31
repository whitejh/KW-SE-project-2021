package com.kw.kw.entity;

import com.kw.kw.custom.PostgreSQLEnumType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
@TypeDef(
        name = "category",
        typeClass = PostgreSQLEnumType.class
)
public class GoodsCategoryPK implements Serializable {
    @Column(name = "goods_id")
    protected Long goodsId;
    @Column(name = "category", columnDefinition = "category")
    @Type(type = "category")
    @Enumerated(EnumType.STRING)
    protected Category category;
}
