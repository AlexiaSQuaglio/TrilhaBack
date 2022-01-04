package trilha.back.financys.dto;

import lombok.*;
import trilha.back.financys.enums.TypeEnum;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChartDTO {
    private String name;
    private TypeEnum type;
    private double Amount;




}
