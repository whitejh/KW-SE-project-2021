package com.kw.kw.entity;

import com.kw.kw.custom.PostgreSQLEnumType;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name="order_")
@ToString (exclude = {"goods", "member"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@TypeDef(
        name = "order_status",
        typeClass = PostgreSQLEnumType.class
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "goods_id")
    @NotNull
    private Goods goods;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "custom_id")
    @NotNull
    private Member member;
    @Column(name = "status", columnDefinition = "order_status")
    @Type(type = "order_status")
    @Enumerated(EnumType.STRING)
    @NotNull
    private OrderStatus orderStatus;
}
