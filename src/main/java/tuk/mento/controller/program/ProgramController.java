package tuk.mento.controller.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.program.ProgramRegisterRequest;
import tuk.mento.service.program.ProgramService;

@Controller
@RequestMapping("/api/v1/program")
public class ProgramController {

    @Autowired
    ProgramService programService;

    @PostMapping
    public ResponseEntity<CustomResponse> registerProgram(@RequestBody ProgramRegisterRequest programRegisterRequest) {
        CustomResponse response = programService.registerProgram(programRegisterRequest);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<CustomResponse> selectProgramList(@RequestParam("keyword") String keyword) {
        CustomResponse response = programService.selectProgramList(keyword);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
}
