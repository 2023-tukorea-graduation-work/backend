package tuk.mento.service.mento;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tuk.mento.common.vo.CustomMap;
import tuk.mento.dto.common.CustomResponse;
import tuk.mento.dto.mento.MentoRegisterRequest;
import tuk.mento.mapper.mento.MentoMapper;
import tuk.mento.s3.manager.S3Manager;

import java.io.IOException;

@Service
public class MentoService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private S3Manager s3Manager;
    @Autowired
    private MentoMapper mentoMapper;

    /*
    * 멘토 회원 등록
    * */
    @Transactional
    public CustomResponse registerMento(MentoRegisterRequest request, MultipartFile image) {
        CustomResponse response = new CustomResponse();
        try {
            // [1] 멘토 회원 등록
            ObjectMapper mapper = new ObjectMapper();
            CustomMap param = mapper.convertValue(request, new TypeReference<CustomMap>() {});

            // [2] 비밀번호 암호화
            param.put("password", passwordEncoder.encode(param.getString("password")));

            // [3] S3 파일업로드
            String url = getUploadedImageURL(image);
            param.put("img_url", url);

            mentoMapper.registerMento(param);

            response.setStatus("SUCCESS");
            response.setMessage("멘토 회원 등록 성공");

        } catch (Exception e) {
            response.setStatus("FAIL");
            response.setMessage("멘토 회원 등록 실패");

            System.out.println("exception: " + e);
        }
        return response;
    }

    /*
    * S3 파일 업로드
    * */
    @Transactional
    public String getUploadedImageURL(MultipartFile image) throws IOException {
        String url = s3Manager.upload(image, s3Manager.getDirName());
        return url;
    }
}
