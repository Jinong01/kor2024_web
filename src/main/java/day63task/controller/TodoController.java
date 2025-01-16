package day63task.controller;

import day63task.model.dto.TodoDto;
import day63task.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/regist")
    public boolean regist(@RequestBody TodoDto todoDto){
        return todoService.regist(todoDto);
    }

    @GetMapping("/printall")
    public List<TodoDto> printAll(){
        return todoService.printAll();
    }

    @PutMapping("/update")
    public boolean update(@RequestBody TodoDto todoDto){
        return todoService.update(todoDto);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int tno){
        return todoService.delete(tno);
    }
}
