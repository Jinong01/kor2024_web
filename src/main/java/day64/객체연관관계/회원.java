package day64.객체연관관계;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor@AllArgsConstructor@Setter@Getter@Builder@ToString
public class 회원 {
    private int 회원번호;
    private String 회원아이디;
    private String 회원이름;
    // 양방향 : 회원객체는 여러개 게시물을 작성할 수 있으므로 List 타입
    @Builder.Default@ToString.Exclude
    List<게시물> 작성한게시물 = new ArrayList<>();
    @Builder.Default@ToString.Exclude
    List<댓글> 작성한댓글 = new ArrayList<>();
    // 양방향 주의할점 : 두 객체가 서로 참조할때는 순환참조(무한호출) 주의해야한다
    // 해결방안1 : ToString 메서드를 사용하지 않는다.
    // 해결방안2 : 참조(양방향) 멤버변수만 ToString 메소드를 사용하지 않는다. @ToString.Exclude
    // ToString() 메소드란? Object 클래스의 메소드로써 객체의 멤버변수 값을 반환함수
        // ToString() 사용하지 않으면 객체 참조시 주소값이 반환 (기본값)
}
