package tuk.mento.service.schedule;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tuk.mento.common.vo.CustomList;
import tuk.mento.common.vo.CustomMap;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.schedule.ScheduleAllRequest;
import tuk.mento.dto.schedule.ScheduleRegisterRequest;
import tuk.mento.mapper.schedule.ScheduleMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;

    /*
     * 일정 등록
     * */
    @Transactional
    public CustomResponse registerSchedule(ScheduleRegisterRequest request) {
        CustomResponse response = new CustomResponse();

        try {
            // [1] 일정 등록
            ObjectMapper mapper = new ObjectMapper();
            CustomMap param = mapper.convertValue(request, new TypeReference<CustomMap>() {});

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime schedule_start_datetime = LocalDateTime.parse(param.getString("schedule_start_datetime"), formatter);
            LocalDateTime schedule_finish_datetime = LocalDateTime.parse(param.getString("schedule_finish_datetime"), formatter);

            param.set("schedule_start_datetime", schedule_start_datetime);
            param.set("schedule_finish_datetime", schedule_finish_datetime);
            scheduleMapper.registerSchedule(param);

            response.setStatus("SUCCESS");
            response.setMessage("일정 등록 성공");
        } catch (Exception e) {
            response.setStatus("FAIL");
            response.setMessage("일정 등록 실패");
            System.out.println("exception: " + e);
        }
        return response;
    }

    /*
     * 등록된 일정 목록 조회
     * */
    public CustomResponse selectAllScheduleByUserGB(ScheduleAllRequest request) {
        CustomResponse response = new CustomResponse();

        try {
            // [1] 일정 등록
            ObjectMapper mapper = new ObjectMapper();
            CustomMap param = mapper.convertValue(request, new TypeReference<CustomMap>() {});

            CustomList<CustomMap> schedules = null;
            switch (request.getUser_gb()) {
               // [1-1] 유저구분 - '멘토' 일경우 멘토 및 멘티 일정 조회
               case "mento" :
                   schedules = scheduleMapper.selectAllScheduleByMento(param);
                    break;
               // [1-2] 유저구분 - '멘티' 일경우 자신의 일정 및 멘토링 일정만 조회
                case "mentee" :
                    schedules = scheduleMapper.selectAllScheduleByMentee(param);
                    break;
            }

            response.setObject(schedules);
            response.setStatus("SUCCESS");
            response.setMessage("등록된 일정 목록 조회 성공");
        } catch (Exception e) {
            response.setStatus("FAIL");
            response.setMessage("등록된 일정 목록 조회 실패");
            System.out.println("exception: " + e);
        }
        return response;
    }
}
