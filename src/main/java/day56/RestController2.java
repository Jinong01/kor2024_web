package day56;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestController2 {

    @GetMapping("/day56/rest2")
    public String[] getRest2(){
        return new String[]{"안녕 클라이언트","나는 GET Rest2 이야" };
    }

    @PostMapping("day56/rest2")
    public String[] postRest2(){
        return new String[]{"안녕 클라이언트","나는 POST Rest2 이야"};
    }

    @PutMapping("day56/rest2")
    public String [] putRest2(){
        return new String[]{"안녕 클라이언트","나는 PUT Rest2 이야"};
    }

    @DeleteMapping("day56/rest2")
    public String [] deleteRest2(){
        return new String[]{"안녕 클라이언트","나는 DELETE Rest2 이야"};
    }
}
