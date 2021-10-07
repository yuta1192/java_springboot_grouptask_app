package com.example.search.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.search.domains.Member;
import com.example.search.mappers.MemberMapper;

@Controller
public class MemberController {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberController(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Member> members = memberMapper.all();
        model.addAttribute("members", members);
        return "index";
    }
    
    @GetMapping("/create")
    public String showCreateFrom() {
    	return "create";
    }
    
    @PostMapping("/create")
    public String create(@RequestParam("member_name") String memberName) {
    	Member member = new Member(memberName);
    	memberMapper.add(member);
    	return "redirect:/";
    }
}