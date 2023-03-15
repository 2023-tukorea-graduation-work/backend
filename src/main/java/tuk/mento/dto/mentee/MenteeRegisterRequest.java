package tuk.mento.dto.mentee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenteeRegisterRequest {
    private String name;
    private String email;
    private String password;
    private int birth_year;
    private String school;
    private int grade;
    private String act_place;
    private String introduction;
}
