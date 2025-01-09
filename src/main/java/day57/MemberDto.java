package day57;

import lombok.*;

@AllArgsConstructor // 모든 매개변수의 생성자 코드를 주입
@NoArgsConstructor // 디폴트 생성자 코드를 주입
@ToString
@Getter
@Setter
@Builder // 빌더패턴 메소드 지원
public class MemberDto {

    private String id;
    private String pwd;

}
