package tuk.mento.service.common.login;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tuk.mento.common.vo.CustomMap;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.common.login.CheckUserEmailDuplicateRequest;
import tuk.mento.dto.common.login.LoginRequest;
import tuk.mento.mapper.common.login.LoginMapper;

@Service
public class LoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    LoginMapper loginMapper;

    /*
    * 로그인
    * */
    @Transactional
    public CustomResponse login(LoginRequest request) {
        CustomResponse response = new CustomResponse();

        try {
            // [1] 로그인
            ObjectMapper mapper = new ObjectMapper();
            CustomMap param = mapper.convertValue(request, new TypeReference<CustomMap>() {});

            // [2] 멘토 / 멘티 로그인 구분은 param: user_gb 값으로 구분 + email check
            CustomMap user = loginMapper.login(param);

            if(user != null) {
                // [2-2] password check
                if(passwordEncoder.matches(request.getPassword(), user.getString("PASSWORD"))) {


                    response.setStatus("SUCCESS");
                    response.setMessage("로그인 성공");
                }
                else {
                    response.setStatus("FAIL");
                    response.setMessage("패스워드 정보가 일치하지 않습니다. 다시 시도해주세요.");
                    throw new Exception();
                }
            }
            else {
                response.setStatus("FAIL");
                response.setMessage("등록되지 않은 이메일 입니다.");
                // 로그인 정보 없음.
                throw new Exception();
            }
            // [3] 로그인 정보 없을 시 exception 있다면 멘토/멘티번호 반환

        } catch (Exception e) {
            System.out.println("exception: " + e);
        }
        return response;
    }

    /*
     * 이메일 중복 체크
     * */
    public CustomResponse checkUserEmailDuplicate(CheckUserEmailDuplicateRequest request) {
        CustomResponse response = new CustomResponse();

        try {
            // [1] 로그인
            ObjectMapper mapper = new ObjectMapper();
            CustomMap param = mapper.convertValue(request, new TypeReference<CustomMap>() {});


        } catch (Exception e) {
            System.out.println("exception: " + e);
        }
        return response;
    }
}
