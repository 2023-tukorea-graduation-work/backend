package tuk.mento.domain.program;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuk.mento.common.domain.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramMatirial extends BaseEntity {
    private int matirial_no;
    private int program_no;
    private String file_path;
}
