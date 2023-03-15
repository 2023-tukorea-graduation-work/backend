package tuk.mento.dto.program;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuk.mento.common.vo.CustomList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramRegisterRequest {
    private int mento_no;
    private String subject;
    private String detail;
    private String pro_start_date;
    private String pro_finish_date;
    private String recruit_start_date;
    private String recruit_finish_date;
    private int capacity;
    private String pro_place;
    private CustomList<ProgramWeekRegisterRequest> programWeeks;
}
