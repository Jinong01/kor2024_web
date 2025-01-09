package day58task.student.controller;

import day58task.student.model.dto.StudentDto;
import day58task.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @ResponseBody
    @PostMapping("/regist")
    public boolean regist(@RequestBody StudentDto studentDto){
        return studentService.regist(studentDto);
    }

    @ResponseBody
    @GetMapping("/printall")
    public ArrayList<StudentDto> printAll(){
        return studentService.printAll();
    }

    @ResponseBody
    @PutMapping("/update")
    public boolean update(@RequestBody StudentDto studentDto){
        return studentService.update(studentDto);
    }

    @ResponseBody
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int sno){
        return studentService.delete(sno);
    }
}
