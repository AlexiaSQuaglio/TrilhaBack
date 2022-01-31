package trilha.back.financys.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trilha.back.financys.enums.TypeEnum;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChartDTO implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String name;
    private Double amount;

}
