package day65task.model.dto;


import day65task.model.entity.UserEntity;
import lombok.*;

@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class UserDto {

    private int uno;
    private String uid;
    private String upwd;
    private String uname;
    private String uphone;
    private String uemail;

    public UserEntity toEntity(){
        return UserEntity.builder().uno(this.uno).uid(this.uid).upwd(this.upwd)
                .uname(this.uname).uphone(this.uphone).uemail(this.uemail).build();
    }
}
