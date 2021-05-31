package com.kw.kw.entity;

import com.kw.kw.custom.PostgreSQLEnumType;
import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.array.EnumArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="member")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@TypeDef(
        name = "role",
        typeClass = PostgreSQLEnumType.class
)
@EntityListeners(value = {AuditingEntityListener.class})
public class Member{
    @Id
    private String id;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name="point")
    private Long point;
    @Column(name="address")
    private String address;
    @Column(name="block_status", columnDefinition = "boolean")
    private Boolean BlockStatus;
    @CreatedDate
    @Column(name="created_at", updatable = false, nullable = false)
    private LocalDateTime regDate;
    @Column(name = "role", columnDefinition = "role")
    @Type(type = "role")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    public void buyGoods(Long price){
        this.point -= price;
    }
}
