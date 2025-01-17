package day65.model.dto;

import day65.model.entity.MemberEntity;
import lombok.*;

@NoArgsConstructor@AllArgsConstructor@Builder@ToString@Getter@Setter
public class MemberDto {
    private int mno;
    private String mid;
    private String mpwd;

    public MemberEntity toEntity(){
        return MemberEntity.builder().mno(this.mno)
                .mid(this.mid).mpwd(this.mpwd).build();
    }
}
