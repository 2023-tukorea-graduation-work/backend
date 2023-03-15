package tuk.mento.controller.common.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.common.login.LoginRequest;
import tuk.mento.service.common.login.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public ResponseEntity<CustomResponse> login(HttpServletRequest httpServletRequest, @RequestBody LoginRequest loginRequest) throws IOException {
        CustomResponse response = loginService.login(loginRequest);
        if("SUCCESS".equals(response.getStatus())) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("loginUserNo", response.getObject());
            session.setAttribute("USER_GB", loginRequest.getUser_gb());
        }
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<CustomResponse> checkUserEmailDuplicate(@RequestBody CheckUserEmailDuplicateRequest checkUserEmailDuplicateRequest) throws IOException {
//        CustomResponse response = loginService.checkUserEmailDuplicate(checkUserEmailDuplicateRequest);
//        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
//    }
}