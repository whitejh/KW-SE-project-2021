package com.kw.kw.service;

import com.kw.kw.dto.PurchaseHistoryDto;
import com.kw.kw.entity.Goods;
import com.kw.kw.entity.Member;
import com.kw.kw.entity.PurchaseHistory;
import com.kw.kw.repository.GoodsRepository;
import com.kw.kw.repository.MemberRepository;
import com.kw.kw.repository.PurchaseHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor //의존성 자동 주입
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {
    private final PurchaseHistoryRepository purchaseHistoryRepository;
    private final MemberRepository memberRepository;
    private final GoodsRepository goodsRepository;
    @Override
    public List<PurchaseHistoryDto> lookupHistoryByMemberId(String memberId) {
        List<PurchaseHistoryDto> result = new ArrayList<>();
        List<PurchaseHistory> findHisotry = purchaseHistoryRepository.findPurchaseHistoryByMemberId(memberId);
        for(PurchaseHistory p : findHisotry){
            result.add(entityToDto(p));
        }
        return result;
    }

    @Override
    @Transactional
    public Long buyGoods(PurchaseHistoryDto dto) throws IllegalArgumentException{
        Member findMember = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버 ID입니다."));
        Goods findGoods = goodsRepository.findById(dto.getGoodsId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품 ID입니다."));
        //멤버가 가진 포인트가 상품의 가격만큼 차감
        if(findMember.getPoint() - findGoods.getPrice() < 0)
            throw new IllegalArgumentException("보유하신 포인트가 부족합니다.");
        findMember.buyGoods(findGoods.getPrice());

        PurchaseHistory purchaseHistory = PurchaseHistory.builder()
                .member(findMember)
                .goods(findGoods)
                .content(dto.getContent())
                .rating(dto.getRating()).build();
        purchaseHistoryRepository.save(purchaseHistory);
        return purchaseHistory.getId();
    }
}
