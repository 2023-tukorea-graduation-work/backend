package tuk.mento.controller.mento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.mento.MentoRegisterRequest;
import tuk.mento.service.mento.MentoService;

import java.io.IOException;

@Controller
@RequestMapping("/api/v1/mento")
public class MentoController {
    @Autowired
    MentoService mentoService;

    @PostMapping
    public ResponseEntity<CustomResponse> registerMento(@RequestPart(value = "data") MentoRegisterRequest mentoRegisterRequest,
                                                        @RequestPart(value = "file", required = false) MultipartFile image) throws IOException {
        CustomResponse response = mentoService.registerMento(mentoRegisterRequest, image);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
}
