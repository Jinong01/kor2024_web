package day65task.model.entity;

import day65task.model.dto.OrderDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "_order")
@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class OrderEntity extends BaseTime{

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ono;

    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String ostate;

    @Column(columnDefinition = "int", nullable = false)
    private int oquantity;

    @Column(columnDefinition = "int", nullable = false)
    private int oamount;

    @ManyToOne
    @JoinColumn(name = "uno")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "pno")
    private ProductEntity productEntity;

    public OrderDto toDto(){
        return OrderDto.builder().ono(this.ono).ostate(this.ostate)
                .oquantity(this.oquantity).oamount(this.oamount).build();
    }
}
