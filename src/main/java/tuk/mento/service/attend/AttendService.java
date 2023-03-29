package tuk.mento.service.attend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuk.mento.common.vo.CustomList;
import tuk.mento.common.vo.CustomMap;
import tuk.mento.dto.attend.AttendRegisterRequest;
import tuk.mento.dto.attend.AttendRelatedInfoRequest;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.mapper.attend.AttendMapper;

@Service
public class AttendService {

    @Autowired
    AttendMapper attendMapper;

    /*
     * 출석 페이지 로딩 전 관련 정보 조회
     * */
    public CustomResponse selectAttendRelatedInfo(AttendRelatedInfoRequest request) {
        CustomResponse response = new CustomResponse();

        try {
            // [1] 출석 페이지 로딩 전 관련 정보 조회
            ObjectMapper mapper = new ObjectMapper();
            CustomMap param = mapper.convertValue(request, new TypeReference<CustomMap>() {});

            // [1-1] 프로그램 참여 멘티 목록 조회
            CustomList<CustomMap> mentees = attendMapper.selectMenteeInProgram(param);

            // [1-2] 특정 주차의 멘토링 일정 및 출석 프로그램 상세 정보 조회
            CustomMap detail = attendMapper.selectMentoProgramSchedule(param);
            detail.set("MENTEES", mentees);

            response.setObject(detail);
            response.setStatus("SUCCESS");
            response.setMessage("출석 페이지 로딩 전 관련 정보 조회 성공");
        } catch (Exception e) {
            response.setStatus("FAIL");
            response.setMessage("출석 페이지 로딩 전 관련 정보 조회 실패");
            System.out.println("exception: " + e);
        }
        return response;
    }

    /*
     * 출석 등록
     * */
    public CustomResponse registerAttend(AttendRegisterRequest request) {
        CustomResponse response = new CustomResponse();

        try {
            // [1] 출석 등록
            ObjectMapper mapper = new ObjectMapper();
            CustomMap param = mapper.convertValue(request, new TypeReference<CustomMap>() {});
            attendMapper.registerAttend(param);

            response.setStatus("SUCCESS");
            response.setMessage("출석 등록 성공");
        } catch (Exception e) {
            response.setStatus("FAIL");
            response.setMessage("출석 등록 실패");
            System.out.println("exception: " + e);
        }
        return response;
    }
}