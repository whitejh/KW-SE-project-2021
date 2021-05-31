package com.kw.kw.service;

import com.kw.kw.dto.GoodsDto;
import com.kw.kw.entity.Goods;
import com.kw.kw.entity.Member;
import com.kw.kw.repository.GoodsRepository;
import com.kw.kw.repository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor //의존성 자동 주입
public class GoodsServiceImpl implements GoodsService{
    private final GoodsRepository repository;
    private final MemberRepository memberRepository;
    @Transactional
    @Override
    public Long register(GoodsDto dto) {
        Member findMember = memberRepository.findById(dto.getSellerId())
                .orElseThrow(() -> new IllegalArgumentException("판매자 ID가 존재하지 않습니다."));
        Goods entity = dtoToEntity(dto, findMember);
        return repository.save(entity).getId();
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
        Goods findEntity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));
        findEntity.update(updateDto, findEntity.getView_count());
        repository.save(findEntity);
        return id;
    }
    @Transactional
    @Override
    public GoodsDto lookup(Long id) throws IllegalArgumentException{
        Goods findEntity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));
        GoodsDto dto = GoodsDto.builder()
                .id(findEntity.getId())
                .view_count(findEntity.getView_count() + 1)
                .name(findEntity.getName())
                .price(findEntity.getPrice())
                .description(findEntity.getDescription())
                .image(findEntity.getImage_blob()).build();
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
                .image(g.getImage_blob()).build()));
        return findGoodsDtos;
    }
}
