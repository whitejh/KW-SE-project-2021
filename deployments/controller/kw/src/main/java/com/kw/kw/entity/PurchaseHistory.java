package com.kw.kw.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name="purchase_history")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PurchaseHistory extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "goods_id")
    private Goods goods;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private Member member;
    @Column(name = "content")
    private String content;
    @Column(name="rating")
    private Long rating;
}
