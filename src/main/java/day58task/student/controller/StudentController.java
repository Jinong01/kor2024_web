package day58task.student.controller;

import day58task.student.model.dto.StudentDto;
import day58task.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/regist")
    public boolean regist(@RequestBody StudentDto studentDto){
        return studentService.regist(studentDto);
    }

    @GetMapping("/printall")
    public ArrayList<StudentDto> printAll(){
        return studentService.printAll();
    }

    @GetMapping("/info")
    public StudentDto info(@RequestParam int sno){
        return studentService.info(sno);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody StudentDto studentDto){
        return studentService.update(studentDto);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int sno){
        return studentService.delete(sno);
    }
}
