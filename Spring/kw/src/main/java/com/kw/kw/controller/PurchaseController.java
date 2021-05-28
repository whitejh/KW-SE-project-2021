package com.kw.kw.controller;

import com.kw.kw.dto.PurchaseHistoryDto;
import com.kw.kw.service.PurchaseHistoryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/PurchaseHistory")
@RequiredArgsConstructor
@Log4j2
public class PurchaseController {
    private final PurchaseHistoryServiceImpl purchaseHistoryService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Map<String, String> exceptionHandler(IllegalIdentifierException ex)
    {
        Map<String, String> errorAttributes = new HashMap<>();
        errorAttributes.put("message", ex.getMessage());
        return errorAttributes;
    }

    @GetMapping("/{id}")
    public List<PurchaseHistoryDto> lookupHistory(@PathVariable("id") Long id)
    {
        List<PurchaseHistoryDto> findHistory = purchaseHistoryService.lookupHistoryByMemberId(id);
        return findHistory;
    }
}
