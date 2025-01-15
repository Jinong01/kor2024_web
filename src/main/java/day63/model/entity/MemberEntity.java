package day63.model.entity;

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
}
