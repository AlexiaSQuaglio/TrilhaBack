package trilha.back.financys.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeEnum {

    REVENUE("revenue"),
    EXPENSE("expense");

    private String typeEnum;

}
