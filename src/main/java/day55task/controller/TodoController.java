package day55task.controller;

import day55task.model.TodoDao;
import day55task.model.TodoDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class TodoController {

    @PostMapping("/regist")
    public boolean regist(@RequestBody TodoDto todoDto){
        return TodoDao.getInstance().regist(todoDto);
    }

    @GetMapping("/print")
    public ArrayList<TodoDto> print(){
        return TodoDao.getInstance().print();
    }

    @PutMapping("/update")
    public boolean update(@RequestParam int no){
        return TodoDao.getInstance().update(no);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int no){
        return TodoDao.getInstance().delete(no);
    }
}
