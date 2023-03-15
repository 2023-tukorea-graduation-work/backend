package tuk.mento.domain.program;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuk.mento.common.domain.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramWeek extends BaseEntity {
    private int program_week_no;
    private int program_no;
    private String detail;
}
