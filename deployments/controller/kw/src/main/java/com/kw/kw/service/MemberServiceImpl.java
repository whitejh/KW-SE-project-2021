package com.kw.kw.service;

import com.kw.kw.dto.MemberDto;
import com.kw.kw.entity.Member;
import com.kw.kw.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor //의존성 자동 주입
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    @Override
    @Transactional
    public String register(MemberDto dto) {
        Member member = dtoToEntity(dto);
        if(!memberRepository.findById(member.getId()).isEmpty())
            throw new IllegalArgumentException("이미 존재하는 ID입니다.");
        memberRepository.save(member);
        return dto.getId();
    }

    @Override
    @Transactional
    public String updateById(String id, MemberDto dto) throws IllegalArgumentException{
        Optional<Member> member = Optional.ofNullable(memberRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버 ID입니다.")));
        return member.get().getId();
    }

    @Override
    public MemberDto findByMemberId(String memberId) {
        Optional<Member> findMember = Optional.ofNullable(memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버 ID입니다.")));
        MemberDto dto = EntityToDto(findMember.get());
        return dto;
    }

    @Override
    public MemberDto findById(String id) {
        Optional<Member> findMember = Optional.ofNullable(memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버 ID입니다.")));
        return EntityToDto(findMember.get());
    }
}
