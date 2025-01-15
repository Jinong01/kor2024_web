package day63.model.entity;

import day63.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class MemberEntity extends BaseTime {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int mno;

    @Column(columnDefinition = "varchar(30)", nullable = false , unique = true)
    private String mid;
    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String mpwd;
    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String mname;
    @Column(columnDefinition = "varchar(13)", nullable = false, unique = true)
    private String mphone;

    // Entity --> Dto
    public MemberDto toDto(){
        // + 빌더패턴 이용한 인스턴스 생성
        // 클래스명.builder().필드명(새로운값).build();
        return MemberDto.builder().mno(this.mno).mid(this.mid)
                .mname(this.mname).mphone(this.mphone).build(); // mpwd는 보안상 제외
    }
}
