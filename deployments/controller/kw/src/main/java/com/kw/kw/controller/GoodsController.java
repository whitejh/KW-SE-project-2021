package com.kw.kw.controller;

import ch.qos.logback.classic.Logger;
import com.kw.kw.dto.GoodsDto;
import com.kw.kw.repository.GoodsRepository;
import com.kw.kw.service.GoodsServiceImpl;
import com.sun.istack.Nullable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ResponseStatus(HttpStatus.BAD_REQUEST) //응답 상태코드를 설정할 수 있다.
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Map<String, String> exceptionHandler(IllegalArgumentException ex)
    {
        Map<String, String> errorAttributes = new HashMap<>();
        errorAttributes.put("message", ex.getMessage());
        return errorAttributes;
    }

    @ApiOperation(value = "상품 상세 조회", notes = "특정 상품을 상세 조회합니다.")
    @GetMapping("/goods/{id}")
    public GoodsDto lookup(@PathVariable("id") Long id)
    {
        GoodsDto findDto = goodsService.lookup(id);
        return findDto;
    }

    @ApiOperation(value = "전체 상품 조회", notes = "모든 상품을 조회합니다.")
    @GetMapping("/goods")
    public List<GoodsDto> findAllGoods()
    {
        List<GoodsDto> findGoods = goodsService.findAllGoods();
        return findGoods;
    }

    @ApiOperation(value = "상품 등록", notes = "상품을 등록합니다.")
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
    @DeleteMapping("/goods/{id}")
    public Long delete(@PathVariable Long id)
    {
        return goodsService.delete(id);
    }
}
