package day54.boardservice13.controller;

import day54.boardservice13.model.dao.BoardDao;
import day54.boardservice13.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


// ========== 콘솔 ========== //
//public class BoardController {
//    private static BoardController instance = new BoardController();
//    private BoardController(){}
//    public static BoardController getInstance(){return instance;}
//
//    // 1. 게시물 쓰기 @POSTMapping()
//    public boolean write(BoardDto boardDto){
//        return BoardDao.getInstance().write(boardDto);
//    }
//
//    // 2. 게시물 전체 조회 @GETMapping
//    public ArrayList<BoardDto> findAll(){
//        return BoardDao.getInstance().findAll();
//    }
//
//    // 3. 게시물 개별 조회
//
//
//    // 4. 게시물 수정 @PUTMapping
//
//
//    // 5. 게시물 삭제 @DELETEMapping
//
//
//}

// ========== 웹 ========== //
@RestController // 현재 클래스에 rest api 가 가능한 클래스임을 주입한다.
// 콘솔과 다른점 : [1] 클래스 위에 @RestController [2] 함수에 @Mapping 을 한다.
public class BoardController {

    // 1. 게시물 쓰기
    @PostMapping("/write")
    public boolean write(@RequestBody BoardDto boardDto) {
        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);
        return BoardDao.getInstance().write(boardDto);
    }

    // 2. 게시물 전체 조회
    @GetMapping("/findAll")
    public ArrayList<BoardDto> findAll() {
        System.out.println("BoardController.findAll");
        return BoardDao.getInstance().findAll();
    }

    // 3. 게시물 개별 조회 , 쿼리스트링
    @GetMapping("/findId")
    public BoardDto findId(@RequestParam int bno){
        // http://localhost:8080/findId?bno=조회할id
        System.out.println("BoardController.findId");
        System.out.println("bno = " + bno);
        return BoardDao.getInstance().findId(bno);
    }

    // 4. 게시물 수정
    @PutMapping("/update")
    public boolean update(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);
        return BoardDao.getInstance().update(boardDto);
    }

    // 5. 게시물 삭제
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int bno){
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);
        return BoardDao.getInstance().delete(bno);
    }
}