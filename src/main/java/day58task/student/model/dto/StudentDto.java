package day58task.student.model.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString@Getter@Setter@Builder
public class StudentDto {
    private int sno;
    private String sname;
    private int skor;
    private int smath;
    private int seng;
}
