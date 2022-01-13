package trilha.back.financys.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LancamentoDTO {
    private Long categoryId;
    private String name;
    private String description;
    private String amount;
    private String date;
    private String type;
    private boolean paid;


}
