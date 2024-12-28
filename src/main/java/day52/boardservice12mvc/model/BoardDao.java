package day52.boardservice12mvc.model;


import java.util.ArrayList;

public class BoardDao {
    private BoardDao (){}
    private static BoardDao instance = new BoardDao();
    public static BoardDao getInstance() {return instance;}

    ArrayList<BoardDto> boardDb = new ArrayList<>();

    public boolean write(BoardDto boardDto){
        boardDb.add(boardDto);
        return true;
    }

    public ArrayList<BoardDto> findAll(){
        return boardDb;
    }
}
