package day53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// [1] 스프링 서버를 실행하기위한 클래스
@SpringBootApplication // 톰캣(웹) 서버를 세팅해주는 어노테이션
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}

// [2] 외부로부터 HTTP 요청을 매핑(연결)하기 위한 컨트롤러 클래스
@RestController
class day53Controller{
    @PostMapping("/day52")
    public String  postMethod(){
        System.err.println("day53Controller.postMethod");
        return "Server connect POST OK";
    }
    @GetMapping("/day52")
    public String getMethod(){
        System.err.println("day53Controller.getMethod");
        return "Server connect GET OK";
    }
    @PutMapping("/day52")
    public String  putMethod(){
        System.err.println("day53Controller.putMethod");
        return "Server connect PUT OK";
    }
    @DeleteMapping("/day52")
    public String  deleteMethod(){
        System.err.println("day53Controller.deleteMethod");
        return "Server connect DELETE OK";
    }
}
