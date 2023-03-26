package tuk.mento.controller.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.schedule.ScheduleAllRequest;
import tuk.mento.dto.schedule.ScheduleRegisterRequest;
import tuk.mento.service.schedule.ScheduleService;


@Controller
@RequestMapping("/api/v1/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @ResponseBody
    @PostMapping
    public ResponseEntity<CustomResponse> registerSchedule(@RequestBody ScheduleRegisterRequest scheduleRegisterRequest) {
        CustomResponse response = scheduleService.registerSchedule(scheduleRegisterRequest);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/all")
    public ResponseEntity<CustomResponse> selectAllScheduleByUserGB(@RequestBody ScheduleAllRequest scheduleAllRequest) {
        CustomResponse response = scheduleService.selectAllScheduleByUserGB(scheduleAllRequest);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
}