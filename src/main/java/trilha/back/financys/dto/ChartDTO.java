package trilha.back.financys.dto;

import lombok.*;
import trilha.back.financys.enums.TypeEnum;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChartDTO implements Serializable {
    private static final Long serialVersionUID =1L;

    private String name;
    private TypeEnum type;
    private double Amount;


    public ChartDTO(String name, double amount) {
    }
}
