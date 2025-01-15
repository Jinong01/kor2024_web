package day63.service;

import day63.model.dto.MemberDto;
import day63.model.entity.MemberEntity;
import day63.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public boolean signup(MemberDto memberDto) {

        // 1. 저장할 DTO 를 entity 로 변환한다.
        MemberEntity memberEntity = memberDto.toEntity();
        // 2. 변환된 entity 를 save 한다.
        // 3. save 결과 entity 반환 받는다.
        MemberEntity saveEntity = memberRepository.save(memberEntity);
        // 4. 회원번호(auto_increment)를 확인하여 엔티티가 잘 생성 됐는지 확인
        if (saveEntity.getMno() > 0){ // 만약에 회원번호가 생성되었다면
            return true; // 회원가입 성공
        } else {
            return false; // 회원가입 실패
        }
    }

    public List<MemberDto> infoList() {
        // 1. 모든 entity 를 조회한다.
        List<MemberEntity> entityList = memberRepository.findAll();
        // 2. 모든 entity 를 Dto 로 변환한다.
        List<MemberDto> list = new ArrayList<>();
        for (int index = 0; index <= entityList.size() - 1; index++) {
            MemberEntity entity = entityList.get(index);
            list.add(entity.toDto());
        }
        return list;
    }
}
