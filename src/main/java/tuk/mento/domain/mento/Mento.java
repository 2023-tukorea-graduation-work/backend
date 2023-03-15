package tuk.mento.domain.mento;

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
public class Mento extends BaseEntity {
    private int mento_no;
    private String name;
    private String email;
    private String password;
    private int birth_year;
    private String college;
    private String major;
    private int grade;
    private String act_place;
    private String img_url;
}
