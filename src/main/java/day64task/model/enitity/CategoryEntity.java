package day64task.model.enitity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class CategoryEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;
    @Column(columnDefinition = "varchar(15)", nullable = false, unique = true)
    private String cname;

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude@Builder.Default
    List<ProductEntity> productEntityList = new ArrayList<>();
}
