package day63task.model.dto;


import day63task.model.entity.TodoEntity;
import lombok.*;

@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class TodoDto{
    private int tno;
    private String tcontent;
    private boolean tstate;


    public TodoEntity toEntity(){
        return TodoEntity.builder()
                .tno(this.tno)
                .tcontent(this.tcontent)
                .tstate(this.tstate).build();
    }
}
