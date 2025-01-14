package day61;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AppStart {

    @Autowired
    static BoardRepository boardRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);

        // (1) BoardEntity 클래스로 인스턴스 생성
            // new BoardEntity() : 인스턴스
        BoardEntity boardEntity1 = new BoardEntity(1,"안녕제목","안녕내용");
        BoardEntity boardEntity2 = new BoardEntity(2,"안녕제목2","안녕내용2");
        // 클래스는 1개 인스턴스는 2개


        // 1. 엔티티의 영속성을 부여 - 엔티티를 테이블에 저장하는 함수
        boardRepository.save(boardEntity1);
        boardRepository.save(boardEntity2);

        List<BoardEntity> list = boardRepository.findAll();
    }
}
