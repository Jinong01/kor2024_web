package day65task.model.dto;

import day65task.model.entity.CategoryEntity;
import lombok.*;

@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class CategoryDto {

    private int cno;
    private String cname;

    public CategoryEntity toEntity(){
        return CategoryEntity.builder().cno(this.cno).cname(this.cname).build();
    }
}
