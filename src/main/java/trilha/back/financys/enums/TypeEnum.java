package trilha.back.financys.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeEnum {

    revenue("revenue"),
    expense("expense");

    private String typeEnum;

}
