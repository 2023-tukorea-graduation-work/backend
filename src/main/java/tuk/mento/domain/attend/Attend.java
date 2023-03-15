package tuk.mento.domain.attend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuk.mento.common.domain.BaseEntity;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attend extends BaseEntity {
    private int attend_no;
    private int program_week_no;
    private int mento_no;
    private int mentee_no;
    private String attend_st;
    private int attend_rate;
    private LocalDate attend_datel;
}
