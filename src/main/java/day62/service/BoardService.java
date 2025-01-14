package day62.service;

import day62.model.entity.BoardEntity;
import day62.model.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// MVC 컴포넌트 공통 : 컴포넌트 스캔을 통해 자동으로 스프링 컨테이너에 빈(인스턴스) 주입이 된다.(싱글톤 x)
// 1. Spring MVC 패턴에서 추가된 레이어/구역으로 자바의 비지니스 로직을 담당
public class BoardService {
    // 비지니스 로직이란? 어떤 기능의 실질적인 코드
        // 예] 회원가입에서 (타입변환, 유효성검사, 자료가공)이 아닌 저장에 필요한 코드
    @Autowired
    private BoardRepository boardRepository;
    // 서비스는 무조건 리포지토리를 이용하여 엔티티를 조작하고 요청과 응답을 받는다.
    // 규칙 : 서비스에서 컨트롤러 객체를 사용하면 안된다

    // C : 게시물 쓰기
    public boolean write(BoardEntity boardEntity) {
        boardRepository.save(boardEntity);
        return true;
    }

    // R : 게시물 전체 조회
    public List<BoardEntity> printAll() {
        return boardRepository.findAll();
    }

    // R : 게시물 개별 조회
    public BoardEntity print(int bno) {
        return boardRepository.findById(bno).get();
    }

    // U : 게시물 수정
    @Transactional
    public boolean update(BoardEntity boardEntity) {
        // 1. 수정할 게시물번호를 이용하여 수정할 엔티티를 찾는다.
        BoardEntity updateEntity = boardRepository.findById(boardEntity.getBno()).get();
        // 2. 수정할 엔티티의 값을 setter 이용하여 수정한다.
        updateEntity.setBtitle(boardEntity.getBtitle());
        updateEntity.setBcontent(boardEntity.getBcontent());
        // (영속성) - 엔티티/인스턴스를 수정하면 DB 도 자동으로 같이 수정된다.
        return true;
    }

    // D : 게시물 삭제
    public boolean delete(int bno) {
        boardRepository.deleteById(bno);
        return true;
    }
}
