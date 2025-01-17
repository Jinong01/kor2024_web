package day65.model.entity;

import day65.model.dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board")
@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    @Column(columnDefinition = "varchar(100)" , nullable = false)
    private String btitle;

    @Column(columnDefinition = "longtext")
    private String bcontent;

    // 단방향
    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;

    public BoardDto toDto(){
        return BoardDto.builder().bno(this.bno).btitle(this.btitle)
                .bcontent(this.bcontent).build();
    }
}