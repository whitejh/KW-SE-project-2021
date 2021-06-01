package com.kw.kw.service;

import com.kw.kw.dto.GoodsDto;
import com.kw.kw.entity.Goods;
import com.kw.kw.entity.GoodsCategory;
import com.kw.kw.entity.Member;
import com.kw.kw.repository.GoodsCategoryRepository;
import com.kw.kw.repository.GoodsRepository;
import com.kw.kw.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor //의존성 자동 주입
public class GoodsServiceImpl implements GoodsService{
    private final GoodsRepository repository;
    private final MemberRepository memberRepository;
    private final GoodsCategoryRepository goodsCategoryRepository;

    @Transactional
    @Override
    public Long register(GoodsDto dto) {
        Member findMember = memberRepository.findById(dto.getSellerId())
                .orElseThrow(() -> new IllegalArgumentException("판매자 ID가 존재하지 않습니다."));
        Goods entity = dtoToEntity(dto, findMember);
        Long registerId = repository.save(entity).getId();
        GoodsCategory goodsCategory = GoodsCategory.builder()
                .id(registerId).goods(entity).category(dto.getCategory()).build();
        goodsCategoryRepository.save(goodsCategory);
        return registerId;
    }
    @Transactional
    @Override
    public Long delete(Long id) throws IllegalArgumentException{
        Goods deleteEntity = (repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("삭제할 ID가 존재하지 않습니다.")));
        deleteEntity.changeSeller(null);
        repository.deleteById(id);
        return id;
    }
    @Transactional
    @Override
    public Long updateById(Long id, GoodsDto updateDto) throws IllegalArgumentException{
        //goods 엔티티 업데이트
        Goods findEntity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));
        findEntity.update(updateDto, findEntity.getView_count());
        repository.save(findEntity);
        //카테고리 엔티티 업데이트
        GoodsCategory findCategory = goodsCategoryRepository.findByGoodsId(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품의 카테고리가 존재하지 않습니다."));
        findCategory.updateCategory(updateDto.getCategory());
        return id;
    }
    @Transactional
    @Override
    public GoodsDto lookup(Long id) throws IllegalArgumentException{
        Goods findEntity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));
        GoodsCategory findCategory = goodsCategoryRepository.findByGoodsId(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품의 카테고리가 존재하지 않습니다." + id));
        GoodsDto dto = GoodsDto.builder()
                .id(findEntity.getId())
                .view_count(findEntity.getView_count() + 1)
                .name(findEntity.getName())
                .category(findCategory.getCategory())
                .price(findEntity.getPrice())
                .description(findEntity.getDescription())
                .imagePath(findEntity.getImagePath()).build();
        findEntity.update(dto, dto.getView_count());
        return dto;
    }
    @Transactional(readOnly = true)
    @Override
    public List<GoodsDto> findAllGoods() {
        List<GoodsDto> findGoodsDtos = new ArrayList<>();
        repository.findAll().forEach(g -> findGoodsDtos.add(GoodsDto.builder()
        .id(g.getId())
        .name(g.getName())
        .price(g.getPrice())
        .view_count(g.getView_count())
        .description(g.getDescription())
                .imagePath(g.getImagePath()).build()));
        return findGoodsDtos;
    }
}
