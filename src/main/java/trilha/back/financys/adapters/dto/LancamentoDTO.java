package trilha.back.financys.adapters.dto;

import lombok.*;
import trilha.back.financys.application.enums.TypeEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LancamentoDTO {
    private Long categoryId;
    private String name;
    private String description;
    private Double amount;
    private String date;
    private TypeEnum type;
    private boolean paid;


}
