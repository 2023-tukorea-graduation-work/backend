package tuk.mento.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleUpdateRequest {
    private int schedule_no;
    private String schedule_gb;
    private String content;
    private String schedule_start_datetime;
    private String schedule_finish_datetime;
}
