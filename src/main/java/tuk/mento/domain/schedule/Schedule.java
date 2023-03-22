package tuk.mento.domain.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuk.mento.common.domain.BaseEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule extends BaseEntity {
    private int schedule_no;
    private int program_week_no;
    private int mento_no;
    private int mentee_no;
    private String user_gb;
    private int schedule_gb;
    private LocalDateTime schedule_start_datetime;
    private LocalDateTime schedule_finish_datetime;
}
