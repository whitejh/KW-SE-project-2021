package com.kw.kw.repository;

import com.kw.kw.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {
    @Query(value = "select p from PurchaseHistory p where p.member.id= :member_id")
    List<PurchaseHistory> findPurchaseHistoryByMemberId(@Param("member_id") Long MemberId);
}
