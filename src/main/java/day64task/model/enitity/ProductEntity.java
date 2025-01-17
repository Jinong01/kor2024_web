package day64task.model.enitity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Setter@Getter@ToString@Builder@NoArgsConstructor@AllArgsConstructor
public class ProductEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno;

    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String pname;

    @Column(columnDefinition = "int", nullable = false)
    private int pprice;

    @ManyToOne
    @JoinColumn(name = "cno")
    CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude@Builder.Default
    List<OrderEntity> orderEntityList = new ArrayList<>();

}
