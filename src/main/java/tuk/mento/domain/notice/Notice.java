package tuk.mento.domain.notice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuk.mento.common.domain.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notice extends BaseEntity {
    private int notice_no;
    private int program_no;
    private String notice;
}
