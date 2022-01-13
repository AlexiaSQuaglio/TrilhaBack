package trilha.back.financys.dto;

import lombok.*;
import trilha.back.financys.enums.TypeEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChartDTO  {


    private String name;
    private TypeEnum type;
    private double total;



}
