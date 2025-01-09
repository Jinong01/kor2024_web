package day58task.student.service;

import day58task.student.model.dao.StudentDao;
import day58task.student.model.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public boolean regist(StudentDto studentDto) {
        return studentDao.regist(studentDto);
    }

    public ArrayList<StudentDto> printAll() {
        return studentDao.printAll();
    }

    public boolean update(StudentDto studentDto) {
        return studentDao.update(studentDto);
    }

    public boolean delete(int sno) {
        return studentDao.delete(sno);
    }
}
