package com.kw.kw.entity;

import lombok.*;

import javax.persistence.*;

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

    @Column(columnDefinition = "TEXT")
    private String name;

    private Long price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "view_count")
    private Long view_count;
}
