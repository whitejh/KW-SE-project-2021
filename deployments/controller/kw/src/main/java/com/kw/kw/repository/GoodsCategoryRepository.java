package com.kw.kw.repository;

import com.kw.kw.entity.GoodsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GoodsCategoryRepository extends JpaRepository<GoodsCategory, Long> {
    @Query("select g from GoodsCategory g where g.goods.id = :goods_id")
    Optional<GoodsCategory> findByGoodsId(@Param("goods_id")Long goodsId);
}
