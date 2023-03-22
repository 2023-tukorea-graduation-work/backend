package tuk.mento.controller.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.schedule.ScheduleRegisterRequest;
import tuk.mento.service.schedule.ScheduleService;


public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<CustomResponse> registerSchedule(@RequestBody ScheduleRegisterRequest scheduleRegisterRequest) {
        CustomResponse response = scheduleService.registerSchedule(scheduleRegisterRequest);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
}