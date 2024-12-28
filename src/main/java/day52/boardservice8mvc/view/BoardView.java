package day52.boardservice8mvc.view;

import day52.boardservice8mvc.controller.BoardController;
import day52.boardservice8mvc.model.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    // 싱글톤이란? 프로그램내 1개의 객체만 존재가능한 디자인 패턴
    private BoardView (){}
    private static BoardView instance = new BoardView();
    public static BoardView getInstance(){return instance;}

    private Scanner scan = new Scanner(System.in);

    public void run(){
        while(true){
            System.out.println("1.등록  2.출력 : ");
            int choose = scan.nextInt();
            if(choose==1){
                write();
            } else if(choose==2){
                findAll();
            }
        }
    }

    public void write(){
        System.out.println("[게시물 쓰기 페이지]");
        System.out.println("title : "); String title = scan.next();
        System.out.println("content : "); String content = scan.next();
        System.out.println("pwd : "); int pwd = scan.nextInt();

        BoardDto boardDto = new BoardDto(title , content , pwd);

        boolean result = BoardController.getInstance().write(boardDto);
        if(result) {
            System.out.println("write success");
        } else {
            System.out.println("write fail");
        }
    }


    public void findAll(){
        System.out.println("[게시물 출력 페이지]");
        ArrayList<BoardDto> result = BoardController.getInstance().findAll();
        for (int index = 0; index <= result.size()-1; index++){
            System.out.println("게시물 제목 : " + result.get(index).getTitle());
            System.out.println("게시물 내용 : " + result.get(index).getContent());
            System.out.println();
        }
    }
}
