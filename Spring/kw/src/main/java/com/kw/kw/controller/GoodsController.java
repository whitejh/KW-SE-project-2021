package com.kw.kw.controller;

import ch.qos.logback.classic.Logger;
import com.kw.kw.dto.GoodsDto;
import com.kw.kw.repository.GoodsRepository;
import com.kw.kw.service.GoodsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsServiceImpl goodsService;

    @ResponseStatus(HttpStatus.NOT_FOUND) //응답 상태코드를 설정할 수 있다.
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Map<String, String> exceptionHandler(IllegalArgumentException ex)
    {
        Map<String, String> errorAttributes = new HashMap<>();
        errorAttributes.put("message", ex.getMessage());
        return errorAttributes;
    }
    @GetMapping("/{id}")
    public GoodsDto lookup(@PathVariable("id") Long id)
    {
        GoodsDto findDto = goodsService.lookup(id);
        return findDto;
    }

    @GetMapping("/")
    public List<GoodsDto> findAllGoods()
    {
        List<GoodsDto> findGoods = goodsService.findAllGoods();
        return findGoods;
    }

    @PostMapping("/")
    public Long register(GoodsDto dto)
    {
        return goodsService.register(dto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, GoodsDto updateDto)
    {
        return goodsService.updateById(id, updateDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id)
    {
        return goodsService.delete(id);
    }
}
