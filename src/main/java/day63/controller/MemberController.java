package day63.controller;

import day63.model.entity.MemberEntity;
import day63.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/member/signup")
    public boolean signup(@RequestBody MemberEntity memberEntity){
        return memberService.signup(memberEntity);
    }

    @GetMapping("/member/infolist")
    public List<MemberEntity> infoList(){
        return memberService.infoList();
    }
}
