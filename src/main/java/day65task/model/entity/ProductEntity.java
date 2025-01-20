package day65task.model.entity;

import day65task.model.dto.ProductDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class ProductEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String pname;

    @Column(columnDefinition = "int", nullable = false)
    private int pprice;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude@Builder.Default
    private List<OrderEntity> orderEntityList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cno")
    private CategoryEntity categoryEntity;

    public ProductDto toDto(){
        return ProductDto.builder().pno(this.pno).pname(this.pname).pprice(this.pprice).build();
    }
}
