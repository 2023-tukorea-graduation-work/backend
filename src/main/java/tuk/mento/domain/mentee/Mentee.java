package tuk.mento.domain.mentee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuk.mento.common.domain.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mentee extends BaseEntity {
    private int mentee_no;
    private String name;
    private String email;
    private String password;
    private int birth_year;
    private String school;
    private int grade;
    private String act_place;
    private String img_url;
}
