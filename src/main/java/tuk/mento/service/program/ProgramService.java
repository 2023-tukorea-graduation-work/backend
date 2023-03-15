package tuk.mento.service.program;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tuk.mento.common.vo.CustomMap;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.program.ProgramRegisterRequest;
import tuk.mento.mapper.program.ProgramMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ProgramService {

    @Autowired
    ProgramMapper programMapper;

    /*
     * 프로그램 등록
     * */
    @Transactional
    public CustomResponse registerProgram(ProgramRegisterRequest request) {
        CustomResponse response = new CustomResponse();

        try {
            // [1] 프로그램 정보 등록
            ObjectMapper mapper = new ObjectMapper();
            CustomMap param = mapper.convertValue(request, new TypeReference<CustomMap>() {});

            System.out.println(param);

            // [1-2] 날짜 데이터 형식 변환(String -> LocalDate)
            param.set("pro_start_date", convertStringToLocalDate(param.getString("pro_start_date")));
            param.set("pro_finish_date", convertStringToLocalDate(param.getString("pro_finish_date")));
            param.set("recruit_start_date", convertStringToLocalDate(param.getString("recruit_start_date")));
            param.set("recruit_finish_date", convertStringToLocalDate(param.getString("recruit_finish_date")));
            programMapper.registerProgram(param);

            // [2] 프로그램 주차별 정보 등록
            System.out.println(param);
            programMapper.registerProgramWeek(param);

            response.setStatus("SUCCESS");
            response.setMessage("프로그램 정보 등록 성공");
        } catch (Exception e) {
            response.setStatus("FAIL");
            response.setMessage("프로그램 정보 등록 실패");
            System.out.println("exception: " + e);
        }
        return response;
    }

    private LocalDate convertStringToLocalDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    }
}
