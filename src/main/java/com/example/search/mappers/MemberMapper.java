package com.example.search.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.search.domains.Member;

@Mapper
public interface MemberMapper {
    List<Member> all();
    List<Member> findByNameLike(String words);
    void add(Member member);
}
