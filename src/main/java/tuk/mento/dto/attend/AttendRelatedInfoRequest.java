package tuk.mento.dto.attend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendRelatedInfoRequest {
    private int program_no;
    private int current_program_week;
}
