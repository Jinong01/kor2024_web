package day65task.model.entity;

import day65task.model.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class UserEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uno;
    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String uid;
    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String upwd;
    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String uname;
    @Column(columnDefinition = "varchar(30)")
    private String uphone;
    @Column(columnDefinition = "varchar(30)")
    private String uemail;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default@ToString.Exclude
    private List<OrderEntity> orderEntityList = new ArrayList<>();

    public UserDto toDto(){
        return UserDto.builder().uno(this.uno).uid(this.uid).upwd(this.upwd)
                .uname(this.uname).uphone(this.uphone).uemail(this.uemail).build();
    }

}
