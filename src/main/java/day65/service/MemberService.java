package day65.service;

import day65.model.dto.BoardDto;
import day65.model.entity.BoardEntity;
import day65.model.entity.MemberEntity;
import day65.model.repository.BoardRepository;
import day65.model.repository.MemberRepository;
import jakarta.transaction.Transactional;
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

    @Autowired
    private BoardRepository boardRepository;

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

    @Transactional // 함수안에서 insert,update,delete 쿼리문들은 트랜잭션으로 사용
    // 여러 작업들을 하나의 작업 단위로 묶어, 하나라도 작업이 실패하면 모두 실패/롤백, 모두 성공해야 성공
    public boolean myBoardWrite(BoardDto boardDto) {
        // * 현재 로그인된 회원이 게시물을 작성한다는 가정
        // 1. 현재 로그인된 회원번호를 세션에서 조회한다
        int loginMno = 1; // 예시] 1번인 회원이 로그인된 상태라는 가정
            // 1-2 현재 회원번호의 회원엔티티 조회
        Optional<MemberEntity> optionalMember = memberRepository.findById((loginMno));
            // optional : null 값을 저장/관리 할 수 있는 객체
        if (optionalMember.isPresent()==false){
            return false; // 조회된 엔티티가 없으면 비로그인 상태이므로 실패 종료
        }
        MemberEntity memberEntity = optionalMember.get();
        // 2. 게시물 엔티티 생성한다.
        BoardEntity boardEntity = boardDto.toEntity();
        // 3. 게시물 엔티티에 회원번호를 넣어준다.
        boardEntity.setMemberEntity(memberEntity);
        // 4. 게시물 엔티티 저장하기
        BoardEntity saveEntity = boardRepository.save(boardEntity);
        // 5. .save() : 엔티티 저장을 성공하면 pk 번호를 확인하여 0보다 크면 성공 / 아니면 실패
        if (saveEntity.getBno()>0){return true;}
        return false;
    }
}
