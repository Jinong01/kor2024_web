package day65.service;

import day65.model.dto.BoardDto;
import day65.model.entity.BoardEntity;
import day65.model.entity.MemberEntity;
import day65.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<BoardDto> myBoardList(int mno) {
        // 1. mno 의 회원 Entity 를 찾는다.
        // Optional 클래스 : null 값을 포함 할 수 있는 객체
        // 특징 : 1. Null 을 안전하게 유무 판단
        // 주요메소드 :
            // 1. isPresent() : 값 여부판단
            // 2. .get() : Optional 객체가 갖고 있는 값 반환 함수
        // 사용처 : JPA 의 findById() 함수의 반환 타입.
        Optional<MemberEntity> optionalMember = memberRepository.findById(mno);
        if (optionalMember.isPresent()){
            // findById 함수로 찾은 mno 의 엔티티가 존재하면
            // 그 옵셔널엔티티를 멤버엔티티로 꺼내온다
            MemberEntity entity = optionalMember.get();
            // 2. 찾은 엔티티에서 양방향으로 설정된 게시물 조회
            List<BoardEntity> boardEntityList = entity.getBoardEntityList();
            // 3. 모든 게시물 엔티티를 Dto 로 변환
            // 3-1
//            List<BoardDto> list = new ArrayList<>();
//            for (int index = 0; index <= boardEntityList.size()-1; index++){
//                BoardEntity boardEntity = boardEntityList.get(index);
//                BoardDto boardDto = boardEntity.toDto();
//                list.add(boardDto);
//            }
//            return list;
            // 3-2 .forEach(반복변수->) , -> Java 방법 / => JS 방법
            // List<BoardDto> list = new ArrayList<>();
            // boardEntityList.forEach(boardEntity -> {list.add(boardEntity.toDto());});

            // 3-3 .stream().map( 타입 :: 실행함수명).collect(Collectors.반환할컬렉션타입)
            List<BoardDto> list = boardEntityList.stream()
                    .map(BoardEntity::toDto)
                    .collect(Collectors.toList());
            return list;
        }
        return null;
    }
}
