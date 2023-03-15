package tuk.mento.dto.common;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {
    // HttpStatus
    private String status;
    // Http Default Message
    private String message;
    private Object object;
}