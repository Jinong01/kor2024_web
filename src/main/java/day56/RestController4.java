package day56;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day56/rest4")
public class RestController4 {

    @GetMapping("")
    public boolean getRest4(@RequestParam String key1 , @RequestParam String key2){
        System.out.println("RestController4.getRest4");
        System.out.println("key1 = " + key1 + ", key2 = " + key2);
        return true;
        // 응답 : Content-Type : 'application/json'
    }

    @GetMapping("/dto")
    public boolean getRest44( RestDto restDto){
        // 쿼리스트링의 매개변수명과 DTO 의 멤버변수명이 동일하면 자동으로 매개변수가 주입된다.
        // * 생성자를 꼭 필수로 만들어야한다.
        System.out.println("RestController4.getRest44");
        System.out.println("restDto = " + restDto);
        return false;
    }

    @PostMapping("")
    public String postRest4(@RequestBody RestDto restDto){
        System.out.println("RestController4.postRest4");
        System.out.println("restDto = " + restDto);
        return "응답 보내기";
    }
}
