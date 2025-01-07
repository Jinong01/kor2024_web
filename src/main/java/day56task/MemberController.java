package day56task;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day56task/member")
public class MemberController {

    @PostMapping("/signup")
    public boolean signUp(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.signUp");
        System.out.println("memberDto = " + memberDto);
        return true;
    }

    @PostMapping("/login")
    public boolean logIn(@RequestParam String id, @RequestParam String pwd){
        System.out.println("MemberController.logIn");
        System.out.println("id = " + id + ", pwd = " + pwd);
        return true;
    }

    @GetMapping("")
    public MemberDto myData(@RequestParam String id, @RequestParam String pwd){
        System.out.println("MemberController.myData");
        System.out.println("id = " + id + ", pwd = " + pwd);
        return new MemberDto();
    }

    @PutMapping("")
    public boolean update(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.update");
        System.out.println("memberDto = " + memberDto);
        return true;
    }

    @DeleteMapping("")
    public boolean delete(@RequestParam String id, @RequestParam String pwd){
        System.out.println("MemberController.delete");
        System.out.println("id = " + id + ", pwd = " + pwd);
        return true;
    }
}
