package tuk.mento.service.schedule;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tuk.mento.common.vo.CustomMap;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.schedule.ScheduleRegisterRequest;
import tuk.mento.mapper.schedule.ScheduleMapper;

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
}
