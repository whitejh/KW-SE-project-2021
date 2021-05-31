package com.kw.kw.repository;

import com.kw.kw.entity.GoodsCategory;
import com.kw.kw.entity.GoodsCategoryPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface GoodsCategoryRepository extends JpaRepository<GoodsCategory, GoodsCategoryPK> {
}
