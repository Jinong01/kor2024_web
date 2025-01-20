package day65task.controller;

import day65task.model.dto.OrderDto;
import day65task.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Service service;

    @PostMapping("/order")
    public boolean order(@RequestBody OrderDto orderDto){
        return service.order(orderDto);
    }

    @GetMapping("/mylist")
    public List<OrderDto> mylist (@RequestParam int uno){
        return service.mylist(uno);
    }
}
