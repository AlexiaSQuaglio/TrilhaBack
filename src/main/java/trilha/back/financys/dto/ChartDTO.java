package trilha.back.financys.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trilha.back.financys.enums.TypeEnum;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChartDTO {

    private String name;
    private TypeEnum type;
    private Double amount;
}
