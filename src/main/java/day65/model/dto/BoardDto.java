package day65.model.dto;

import day65.model.entity.BoardEntity;
import lombok.*;

@Getter@Setter@Builder@ToString@AllArgsConstructor@NoArgsConstructor
public class BoardDto {
    private int bno;
    private String btitle;
    private String bcontent;

    public BoardEntity toEntity(){
        return BoardEntity.builder().bno(this.bno).btitle(this.btitle)
                .bcontent(this.bcontent).build();
    }
}
