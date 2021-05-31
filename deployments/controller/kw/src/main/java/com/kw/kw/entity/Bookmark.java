package com.kw.kw.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="bookmark")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Bookmark {
    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
