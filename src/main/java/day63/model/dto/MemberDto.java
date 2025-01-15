package day63.model.dto;

import day63.model.entity.MemberEntity;
import lombok.*;

@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class MemberDto {
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mphone;
    private String cdate; // 회원가입 날짜/시간
    private String udate; // 회원정보 수정 날짜/시간

    // Dto --> Entity
    public MemberEntity toEntity(){
        // (방법1) 빌더패턴 : 인스턴스를 생성자를 이용하여 만들었다면 규칙이 존재하다.
        // 유연한 인스턴스 생성하는 방법 제시 , 순서 바꿔도 되고 값을 빼도 된다.
        return MemberEntity.builder().
                mno(this.mno).mid(this.mid).mpwd(this.mpwd)
                .mname(this.mname).mphone(this.mphone).build();
        // (방법2) 생성자 : 순서 맞춰야하며 하나라도 빠지면 안된다.
        // return new MemberEntity(this.mno,this.mid,this.mpwd,this.mname, this.mphone);

    }
}
