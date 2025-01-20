package day65task.model.dto;

import day65task.model.entity.ProductEntity;
import lombok.*;

@Getter@Setter@ToString@Builder@AllArgsConstructor@NoArgsConstructor
public class ProductDto {

    private int pno;
    private String pname;
    private int pprice;

    public ProductEntity toEntity(){
        return ProductEntity.builder().pno(this.pno).pname(this.pname).pprice(this.pprice).build();
    }
}
