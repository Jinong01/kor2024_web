package day63.service;

import day63.model.entity.MemberEntity;
import day63.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public boolean signup(MemberEntity memberEntity) {
        memberRepository.save(memberEntity);
        return true;
    }

    public List<MemberEntity> infoList() {
        return memberRepository.findAll();
    }
}
