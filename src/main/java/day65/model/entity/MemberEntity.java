package day65.model.entity;

import day65.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter@Setter@ToString@Builder@NoArgsConstructor@AllArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;

    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String mid;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String mpwd;

    //양방향
    @Builder.Default@ToString.Exclude
    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<BoardEntity> boardEntityList = new ArrayList<>();

    public MemberDto toDto(){
        return MemberDto.builder().mno(this.mno)
                .mid(this.mid).mpwd(this.mpwd).build();
    }

}
