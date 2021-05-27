package com.kw.kw.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="member")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Member extends BaseEntity{
    @Id
    @NotNull
    private String id;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name="point")
    private Long point;
    @Column(name="password")
    private String password;
    @Column(name="address")
    private String address;
    @Column(name="block_status", columnDefinition = "boolean")
    private Boolean BlockStatus;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private PurchaseHistory purchaseHistory;
    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Bookmark bookmark;
}
