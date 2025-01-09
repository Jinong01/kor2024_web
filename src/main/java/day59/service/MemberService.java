package day59.service;

import day59.model.dao.MemberDao;
import day59.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    public boolean signup(MemberDto memberDto) {
        return memberDao.signup(memberDto);
    }

    public boolean login(String mid, String mpwd) {
        return memberDao.login(mid, mpwd);
    }
}
