package day53task;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}

@RestController
class day53TaskController{
    @PostMapping("/day53task")
    public String postMethod(){
        System.err.println("day53TaskController.postMethod");
        return "Post 메소드 통신 성공";
    }
    @GetMapping("/day53task")
    public String getMethod(){
        System.err.println("day53TaskController.getMethod");
        return "GET 메소드 통신 성공";
    }
    @PutMapping("/day53task")
    public String putMethod(){
        System.err.println("day53TaskController.putMethod");
        return "PUT 메소드 통신 성공";
    }
    @DeleteMapping("/day53task")
    public String deleteMethod(){
        System.err.println("day53TaskController.deleteMethod");
        return "DELETE 메소드 통신 성공";
    }
}
