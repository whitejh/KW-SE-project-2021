package com.kw.kw.service;

import com.kw.kw.dto.GoodsDto;
import com.kw.kw.entity.Goods;
import com.kw.kw.repository.GoodsRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor //의존성 자동 주입
public class GoodsServiceImpl implements GoodsService{
    private final GoodsRepository repository;
    @Override
    public Long register(GoodsDto dto) {
        Goods entity = dtoToEntity(dto);
        Goods saveEntity = repository.save(entity);
        return entity.getId();
    }
}
