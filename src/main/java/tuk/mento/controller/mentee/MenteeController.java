package tuk.mento.controller.mentee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.mentee.MenteeRegisterRequest;
import tuk.mento.service.mentee.MenteeService;

import java.io.IOException;

@Controller
@RequestMapping("/api/v1/mentee")
public class MenteeController {

    @Autowired
    MenteeService menteeService;

    @PostMapping
    public ResponseEntity<CustomResponse> registerMento(@RequestPart(value = "data") MenteeRegisterRequest menteeRegisterRequest,
                                                        @RequestPart(value = "file", required = false) MultipartFile image) throws IOException {
        CustomResponse response = menteeService.registerMentee(menteeRegisterRequest, image);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
}
