package day58;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}

@Controller
class ViewController{
    @GetMapping("")
    public String index(){
        return "/day58/index.html";
    }
    @GetMapping("/layout")
    public String index2(){
        return "/day58/layout/index.html";
    }
    @GetMapping("/student")
    public String studentIndex(){
        return "/day58/student/index.html";
        // 지정한 경로에 위치한 타임리프 템플릿을 렌더링하여 HTML 로 반환, 동적파일-->정적파일
        // 해당 클래스에는 @RestController/@ResponseBody 를 사용하면 안된다.
    }
    @GetMapping("/student/regist")
    public String regist(){
        return "/day58/student/regist.html";
    }
    @GetMapping("/student/list")
    public String list(){
        return "/day58/student/list.html";
    }
    @GetMapping("/student/info")
    public String info(){
        return "/day58/student/info.html";
    }
    @GetMapping("/student/update")
    public String update(){
        return "/day58/student/update.html";
    }
    @GetMapping("/student/delete")
    public String delete(){
        return "/day58/student/delete.html";
    }
}