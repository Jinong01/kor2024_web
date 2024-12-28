package day52.boardservice8mvc.controller;

import day52.boardservice8mvc.model.BoardDao;
import day52.boardservice8mvc.model.BoardDto;

import java.util.ArrayList;

public class BoardController {
    private BoardController(){}
    private static BoardController instance = new BoardController();
    public static BoardController getInstance() {return instance;}

    public boolean write(BoardDto boardDto){
        return BoardDao.getInstance().write(boardDto);
    }

    public ArrayList<BoardDto> findAll(){
        return BoardDao.getInstance().findAll();
    }
}
