package com.kw.kw.controller;

import com.kw.kw.dto.MemberDto;
import com.kw.kw.service.MemberServiceImpl;
import com.sun.istack.NotNull;
import io.swagger.annotations.*;
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
    @ApiOperation(value = "멤버의 정보 업데이트", notes = "특정 ID의 멤버의 정보를 업데이트합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "업데이트할 멤버의 주소", required = true),
            @ApiImplicitParam(name = "blockStatus", value = "업데이트할 멤버의 block여부", required = true),
            @ApiImplicitParam(name = "id", value = "업데이트할 멤버의 ID", required = true),
            @ApiImplicitParam(name = "member_id", value = "업데이트할 멤버의 닉네임", required = true),
            @ApiImplicitParam(name = "phone_number", value = "업데이트할 멤버의 전화번호", required = true),
            @ApiImplicitParam(name = "password", value = "업데이트할 멤버의 비밀번호", required = true),
            @ApiImplicitParam(name = "point", value = "업데이트할 멤버의 포인트", required = true),
            @ApiImplicitParam(name = "role", value = "업데이트할 멤버의 역할 (ADMIN, CONSUMER, SELLER)", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "수정 성공"),
            @ApiResponse(code = 400, message = "존재하지 않는 ID")
    })
    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable @RequestParam String id,
                                     @ModelAttribute MemberDto dto)
    {
        memberService.updateById(id, dto);
        return new ResponseEntity<>("회원정보가 업데이트 되었습니다.", HttpStatus.OK);
    }
    @ApiOperation(value = "멤버의 정보 조회", notes = "특정 ID의 멤버의 정보를 조회합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "조회할 멤버의 ID", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "수정 성공"),
            @ApiResponse(code = 400, message = "존재하지 않는 ID")
    })
    @GetMapping("/{id}")
    public MemberDto lookupMemberById(@PathVariable String id)
    {
        return memberService.findById(id);
    }
}
