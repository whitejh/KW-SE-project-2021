package com.kw.kw.controller;

import com.kw.kw.dto.PurchaseHistoryDto;
import com.kw.kw.service.PurchaseHistoryServiceImpl;
import io.swagger.annotations.*;
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

    @ApiOperation(value = "멤버의 구매내역 조회", notes = "특정 ID의 멤버의 구매내역을 조회합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "조회할 멤버의 ID", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 400, message = "존재하지 않는 ID")
    })
    @GetMapping("/{id}")
    public List<PurchaseHistoryDto> lookupHistory(@PathVariable("id") String id)
    {
        List<PurchaseHistoryDto> findHistory = purchaseHistoryService.lookupHistoryByMemberId(id);
        return findHistory;
    }
}
