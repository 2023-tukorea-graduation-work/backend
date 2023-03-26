package tuk.mento.dto.attend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendRegisterRequest {
    private int program_week_no;
    private int mentee_no;
    private int mento_no;
    private String attend_st;
}
