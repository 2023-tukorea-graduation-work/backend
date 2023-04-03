package tuk.mento.controller.program;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.program.ParticipateProgramRequest;
import tuk.mento.dto.program.ProgramRegisterRequest;
import tuk.mento.itext.PDFCreator;
import tuk.mento.service.program.ProgramService;

import java.io.IOException;

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

    @ResponseBody
    @GetMapping("/{program_no}")
    public ResponseEntity<CustomResponse> selectProgramDetail(@PathVariable("program_no") int program_no) {
        CustomResponse response = programService.selectProgramDetail(program_no);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/parti")
    public ResponseEntity<CustomResponse> participateProgramForMentee(@RequestBody ParticipateProgramRequest participateProgramRequest) {
        CustomResponse response = programService.participateProgramForMentee(participateProgramRequest);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/pdf")
    public ResponseEntity<CustomResponse> createPdf() throws DocumentException, IOException {
        PDFCreator creator = new PDFCreator();
        creator.createPdf();
        CustomResponse response = new CustomResponse();
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
}
