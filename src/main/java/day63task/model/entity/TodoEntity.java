package day63task.model.entity;

import day63task.model.dto.TodoDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todolist")
@Setter@Getter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class TodoEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tno;

    @Column (columnDefinition = "varchar(30)", nullable = false)
    private String tcontent;

    @Column (columnDefinition = "boolean")
    @Builder.Default
    private boolean tstate = false;

    public TodoDto toDto(){
        return TodoDto.builder().tno(this.tno)
                .tcontent(this.tcontent).tstate(this.tstate).build();
    }
}
