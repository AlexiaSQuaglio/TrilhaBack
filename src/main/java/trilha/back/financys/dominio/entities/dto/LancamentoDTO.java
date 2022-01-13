package trilha.back.financys.dto;

import lombok.*;
import trilha.back.financys.dominio.entities.enums.TypeEnum;

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
