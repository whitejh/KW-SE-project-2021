package com.kw.kw.entity;

import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.array.EnumArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.*;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="member")
@ToString
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
                                value = "roll"
                        )
                }
        )
})
public class Member{
    @Id
    @NotNull
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
    @Column(name = "roll", columnDefinition = "roll")
    @NotNull
    private Roll roll;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private PurchaseHistory purchaseHistory;
    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Bookmark bookmark;
}
