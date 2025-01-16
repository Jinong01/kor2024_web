package day64.JPA연관관계.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reply")
@Getter@Setter@Builder@ToString@AllArgsConstructor@NoArgsConstructor
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String rcontent;

    // 단방향
    @ManyToOne
    @JoinColumn(name = "bno")
    private BoardEntity boardEntity;

    // 단방향
    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;
}
