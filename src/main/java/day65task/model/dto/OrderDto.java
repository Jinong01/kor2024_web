package day65task.model.dto;

import day65task.model.entity.OrderEntity;
import lombok.*;

@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class OrderDto {
    private int ono;
    private String ostate;
    private int oquantity;
    private int oamount;

    public OrderEntity toEntity(){
        return OrderEntity.builder().ono(this.ono).ostate(this.ostate)
                .oquantity(this.oquantity).oamount(this.oamount).build();
    }
}
