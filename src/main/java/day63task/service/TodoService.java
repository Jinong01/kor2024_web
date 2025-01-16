package day63task.service;

import day63task.model.dto.TodoDto;
import day63task.model.entity.TodoEntity;
import day63task.model.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public boolean regist(TodoDto todoDto) {
        TodoEntity todoEntity = todoDto.toEntity();
        TodoEntity saveEntity = todoRepository.save(todoEntity);
        if (saveEntity.getTno() > 0){ return true;
        } else { return false; }
    }

    public List<TodoDto> printAll() {
        List<TodoEntity> entityList = todoRepository.findAll();
        List<TodoDto> list = new ArrayList<>();
        for (int index = 0; index <= entityList.size()-1; index++){
            TodoEntity todoEntity = entityList.get(index);
            list.add(todoEntity.toDto());
        }
        return list;
    }

    @Transactional
    public boolean update(TodoDto todoDto) {
        TodoEntity updateEntity = todoRepository.findById(todoDto.getTno()).get();
        updateEntity.setTstate(!updateEntity.isTstate());
        System.out.println(todoDto.isTstate());
        return true;
    }

    public boolean delete(int tno) {
        todoRepository.deleteById(tno);
        return true;
    }
}
