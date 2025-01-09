package day59.controller;

import day59.model.dto.MemberDto;
import day59.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/signup.do")
    public boolean signup(@RequestBody MemberDto memberDto){
        return memberService.signup(memberDto);
    }

    @GetMapping("/login.do")
    public boolean login(@RequestParam String mid, @RequestParam String mpwd){
        return memberService.login(mid,mpwd);
    }
}
