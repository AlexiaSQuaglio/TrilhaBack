package trilha.back.financys.adapters.dto;

import lombok.*;
import trilha.back.financys.application.enums.TypeEnum;

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
