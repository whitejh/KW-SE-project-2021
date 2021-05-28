package com.kw.kw.service;

import com.kw.kw.dto.PurchaseHistoryDto;
import com.kw.kw.entity.PurchaseHistory;
import com.kw.kw.repository.PurchaseHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor //의존성 자동 주입
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {
    private final PurchaseHistoryRepository purchaseHistoryRepository;
    @Override
    public List<PurchaseHistoryDto> lookupHistoryByMemberId(String memberId) {
        List<PurchaseHistoryDto> result = new ArrayList<>();
        List<PurchaseHistory> findHisotry = purchaseHistoryRepository.findPurchaseHistoryByMemberId(memberId);
        for(PurchaseHistory p : findHisotry){
            result.add(entityToDto(p));
        }
        return result;
    }
}
