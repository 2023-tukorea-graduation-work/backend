package tuk.mento.domain.program;

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
public class Program extends BaseEntity {
    private int program_no;
    private int mento_no;
    private String subject;
    private String detail;
    private LocalDate pro_start_date;
    private LocalDate pro_finish_date;
    private LocalDate recruit_start_date;
    private LocalDate recurit_finish_date;
    private int capacity;
    private String pro_place;
}
