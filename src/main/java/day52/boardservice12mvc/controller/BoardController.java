package day52.boardservice12mvc.controller;

import day52.boardservice12mvc.model.BoardDao;
import day52.boardservice12mvc.model.BoardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class BoardController {

    @PostMapping("/day52/write")
    public boolean write(BoardDto boardDto){
        return BoardDao.getInstance().write(boardDto);
    }

    @GetMapping("/day52/findall")
    public ArrayList<BoardDto> findAll(){
        return BoardDao.getInstance().findAll();
    }
}
