package tuk.mento.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRegisterRequest {
    private int program_week_no;
    private int mentee_no;
    private int mento_no;
    private String user_gb;
    private String schedule_gb;
    private String content;
    private String schedule_start_datetime;
    private String schedule_finish_datetime;
}
