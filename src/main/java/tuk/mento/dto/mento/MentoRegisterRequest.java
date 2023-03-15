package tuk.mento.dto.mento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentoRegisterRequest {
    private String name;
    private String email;
    private String password;
    private int birth_year;
    private String college;
    private String major;
    private int grade;
    private String introduction;
    private String act_place;
}
