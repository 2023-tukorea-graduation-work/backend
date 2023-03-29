package tuk.mento.dto.attend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuk.mento.common.vo.CustomList;
import tuk.mento.common.vo.CustomMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendRegisterRequest {
    private int program_week_no;
    private int mento_no;
    private CustomList<CustomMap> attends;
}
