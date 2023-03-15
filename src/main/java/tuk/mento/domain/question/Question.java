package tuk.mento.domain.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuk.mento.common.domain.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question extends BaseEntity {
    private int question_no;
    private int program_no;
    private int mento_no;
    private int mentee_no;
    private String question;
    private String answer;
}
