package com.kw.kw.controller;

import ch.qos.logback.classic.Logger;
import com.kw.kw.dto.GoodsDto;
import com.kw.kw.dto.MemberDto;
import com.kw.kw.dto.PurchaseHistoryDto;
import com.kw.kw.repository.GoodsRepository;
import com.kw.kw.service.GoodsServiceImpl;
import com.kw.kw.service.MemberServiceImpl;
import com.kw.kw.service.PurchaseHistoryService;
import com.kw.kw.service.PurchaseHistoryServiceImpl;
import com.sun.istack.Nullable;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = {"1. Goods"})
@RestController
@RequiredArgsConstructor
@Log4j2
public class GoodsController {
    private final GoodsServiceImpl goodsService;
    private final MemberServiceImpl memberService;
    private final PurchaseHistoryServiceImpl purchaseHistoryService;

    @ResponseStatus(HttpStatus.BAD_REQUEST) //응답 상태코드를 설정할 수 있다.
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Map<String, String> exceptionHandler(IllegalArgumentException ex)
    {
        Map<String, String> errorAttributes = new HashMap<>();
        errorAttributes.put("message", ex.getMessage());
        return errorAttributes;
    }

    @ApiOperation(value = "상품 상세 조회", notes = "특정 상품을 상세 조회합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "조회할 상품의 아이디", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 404, message = "존재하지 않는 ID")
    })
    @GetMapping("/goods/{id}")
    public GoodsDto lookup(@PathVariable("id") Long id)
    {
        GoodsDto findDto = goodsService.lookup(id);
        return findDto;
    }

    @ApiOperation(value = "전체 상품 조회", notes = "모든 상품을 조회합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "조회 성공"),
    })
    @GetMapping("/goods")
    public List<GoodsDto> findAllGoods()
    {
        List<GoodsDto> findGoods = goodsService.findAllGoods();
        return findGoods;
    }

    @ApiOperation(value = "상품 등록", notes = "상품을 등록합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "등록할 상품의 이름", required = true),
            @ApiImplicitParam(name = "description", value = "등록할 상품의 설명", required = true),
            @ApiImplicitParam(name = "price", value = "등록할 상품의 가격", required = true),
            @ApiImplicitParam(name = "image", value = "등록할 상품의 이미지", required = false),
            @ApiImplicitParam(name = "view_count", value = "조회수", readOnly = true)
    })
    @PostMapping("/goods")
    public Long register(@ModelAttribute GoodsDto dto,
                         @Nullable @RequestParam(value="file", required = false) MultipartFile file) throws IOException {
        if(null == file){
            log.info("register : 인자로 넘어온 파일이 없습니다.");
        }
        else{
            log.info("--------file-------");
            byte[] bytes = file.getBytes();
            dto.setImage(bytes);
        }
        return goodsService.register(dto);
    }

    @ApiOperation(value = "등록한 상품 수정", notes = "등록한 상품을 수정합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "수정할 상품의 이름", required = true),
            @ApiImplicitParam(name = "description", value = "수정할 상품의 설명", required = true),
            @ApiImplicitParam(name = "price", value = "수정할 상품의 가격", required = true),
            @ApiImplicitParam(name = "image", value = "수정할 상품의 이미지", required = false),
            @ApiImplicitParam(name = "view_count", value = "조회수", readOnly = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "수정 성공"),
            @ApiResponse(code = 404, message = "존재하지 않는 ID")
    })
    @PutMapping("/goods/{id}")
    public Long update(@PathVariable Long id,
                       @ModelAttribute GoodsDto updateDto,
                       @Nullable @RequestParam(value="file", required = false) MultipartFile file) throws IOException {
        if(null == file){
            log.info("update : 인자로 넘어온 파일이 없습니다.");
        }
        else{
            log.info("--------file-------");
            byte[] bytes = file.getBytes();
            updateDto.setImage(bytes);
        }
        return goodsService.updateById(id, updateDto);
    }

    @ApiOperation(value = "등록한 상품 삭제", notes = "등록한 상품을 삭제합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "삭제할 상품의 ID", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "삭제 성공"),
            @ApiResponse(code = 404, message = "존재하지 않는 ID")
    })
    @DeleteMapping("/goods/{id}")
    public Long delete(@PathVariable Long id)
    {
        return goodsService.delete(id);
    }

    @ApiOperation(value = "상품 구매", notes = "상품을 구매합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberId", value = "구매할 멤버의 ID", required = true, dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "goodsId", value = "구매할 상품의 ID", required = true, dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "rating", value = "상품의 평점 (1~5)", required = true, dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "content", value = "상품의 후기", required = false, dataType = "string", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "구매 성공"),
            @ApiResponse(code = 400, message = "존재하지 않는 멤버 ID이거나, 상품 ID")
    })
    @PostMapping("/goods/{id}")
    public ResponseEntity buyGoods(@ModelAttribute PurchaseHistoryDto purchaseHistoryDto){
        purchaseHistoryService.buyGoods(purchaseHistoryDto);
        return new ResponseEntity<>("구매가 완료되었습니다.", HttpStatus.OK);
    }
}
