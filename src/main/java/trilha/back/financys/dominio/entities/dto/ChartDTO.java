package trilha.back.financys.dto;

import lombok.*;
import trilha.back.financys.dominio.entities.enums.TypeEnum;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChartDTO  {


    private String name;
    private TypeEnum type;
    private Double amount;
    private Double total;



}
