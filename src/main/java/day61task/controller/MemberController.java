package day61task.controller;

import day61task.model.entity.MemberEntity;
import day61task.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public boolean signup(@RequestParam String id, @RequestParam String pwd){
        return memberService.signup(id,pwd);
    }

    @GetMapping("/findAll")
    public List<MemberEntity> findAll(){
        return memberService.findAll();
    }
}
