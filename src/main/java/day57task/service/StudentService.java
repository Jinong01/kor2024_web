package day57task.service;

import day57task.model.Dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    // spring 에서 대신 만든 객체를 주세요.
    @Autowired
    private StudentDao studentDao;
}
