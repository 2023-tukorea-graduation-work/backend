package tuk.mento.controller.attend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tuk.mento.dto.attend.AttendRegisterRequest;
import tuk.mento.dto.attend.AttendRelatedInfoRequest;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.service.attend.AttendService;

@Controller
@RequestMapping("/api/v1/attend")
public class AttendController {

    @Autowired
    AttendService attendService;

    @ResponseBody
    @PostMapping("/info")
    public ResponseEntity<CustomResponse> selectAttendRelatedInfo(@RequestBody AttendRelatedInfoRequest attendRelatedInfoRequest) {
        CustomResponse response = attendService.selectAttendRelatedInfo(attendRelatedInfoRequest);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity<CustomResponse> registerAttend(@RequestBody AttendRegisterRequest attendRegisterRequest) {
        CustomResponse response = attendService.registerAttend(attendRegisterRequest);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
}
