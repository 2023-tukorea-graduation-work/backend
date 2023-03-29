package tuk.mento.service.program;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tuk.mento.common.vo.CustomList;
import tuk.mento.common.vo.CustomMap;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.program.ParticipateProgramRequest;
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

            // [1-2] 날짜 데이터 형식 변환(String -> LocalDate)
            param.set("pro_start_date", convertStringToLocalDate(param.getString("pro_start_date")));
            param.set("pro_finish_date", convertStringToLocalDate(param.getString("pro_finish_date")));
            param.set("recruit_start_date", convertStringToLocalDate(param.getString("recruit_start_date")));
            param.set("recruit_finish_date", convertStringToLocalDate(param.getString("recruit_finish_date")));
            programMapper.registerProgram(param);

            // [2] 프로그램 주차별 정보 등록
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

    /*
     * 프로그램 목록 조회
     * */
    @Transactional
    public CustomResponse selectProgramList(String keyword) {
        CustomResponse response = new CustomResponse();

        try {
            // [1] 프로그램 목록 조회
            CustomList<CustomMap> programs = programMapper.selectProgramList(keyword);

            response.setObject(programs);
            response.setStatus("SUCCESS");
            response.setMessage("프로그램 목록 조회 성공");
        } catch (Exception e) {
            response.setStatus("FAIL");
            response.setMessage("프로그램 목록 조회 실패");
            System.out.println("exception: " + e);
        }
        return response;
    }

    /*
     * 프로그램 상세 조회
     * */
    @Transactional
    public CustomResponse selectProgramDetail(int program_no) {
        CustomResponse response = new CustomResponse();

        try {
            // [1] 프로그램 상세 조회
            CustomMap program = programMapper.selectProgramDetail(program_no);

            // [2] 프로그램 주차별 정보 조회
            CustomList<CustomMap> weeks = programMapper.selectProgramWeekList(program_no);
            program.set("WEEKS", weeks);

            response.setObject(program);
            response.setStatus("SUCCESS");
            response.setMessage("프로그램 상세 조회 성공");
        } catch (Exception e) {
            response.setStatus("FAIL");
            response.setMessage("프로그램 상세 조회 실패");
            System.out.println("exception: " + e);
        }
        return response;
    }

    /*
     * 프로그램 신청 정보 등록
     * */
    @Transactional
    public CustomResponse participateProgramForMentee(ParticipateProgramRequest request) {
        CustomResponse response = new CustomResponse();

        try {

            response.setStatus("SUCCESS");
            response.setMessage("프로그램 신청 정보 등록 성공");
        } catch (Exception e) {
            response.setStatus("FAIL");
            response.setMessage("프로그램 신청 정보 등록 실패");
            System.out.println("exception: " + e);
        }
        return response;
    }

    private LocalDate convertStringToLocalDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    }
}
