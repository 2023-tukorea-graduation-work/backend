package tuk.mento.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleAllRequest {
    private int user_no;
    private int program_no;
    private String user_gb;
    private String schedule_start_date;
}
