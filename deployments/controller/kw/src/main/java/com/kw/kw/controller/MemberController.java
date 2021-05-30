package com.kw.kw.controller;

import com.kw.kw.dto.MemberDto;
import com.kw.kw.service.MemberServiceImpl;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Log4j2
public class MemberController {
    private final MemberServiceImpl memberService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Map<String, String> exceptionHandler(IllegalIdentifierException ex)
    {
        Map<String, String> errorAttributes = new HashMap<>();
        errorAttributes.put("message", ex.getMessage());
        return errorAttributes;
    }
    @PostMapping("/")
    public ResponseEntity register(@RequestBody MemberDto dto)
    {
        memberService.register(dto);
        return new ResponseEntity<>("회원이 등록되었습니다.", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable @RequestParam Long id,
                                     @RequestBody MemberDto dto)
    {
        memberService.updateById(id, dto);
        return new ResponseEntity<>("회원정보가 업데이트 되었습니다.", HttpStatus.OK);
    }
}
