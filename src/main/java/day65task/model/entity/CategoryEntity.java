package day65task.model.entity;

import day65task.model.dto.CategoryDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class CategoryEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String cname;

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude@Builder.Default
    private List<ProductEntity> productEntityList = new ArrayList<>();

    public CategoryDto toDto(){
        return CategoryDto.builder().cno(this.cno).cname(this.cname).build();
    }
}
