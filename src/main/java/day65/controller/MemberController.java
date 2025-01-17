package day65.controller;

import day65.model.dto.BoardDto;
import day65.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/info/board/findall")
    public List<BoardDto> myBoardList(@RequestParam int mno){
        return memberService.myBoardList(mno);
    }
}
