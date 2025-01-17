package day64task.model.enitity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "_order")
@Setter@Getter@ToString@Builder@NoArgsConstructor@AllArgsConstructor
public class OrderEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ono;

    @Column(columnDefinition = "int")
    private int ocount;

    @ManyToOne
    @JoinColumn(name = "pno")
    ProductEntity productEntity;
}
