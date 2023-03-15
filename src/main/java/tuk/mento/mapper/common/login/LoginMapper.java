package tuk.mento.mapper.common.login;

import org.apache.ibatis.annotations.Mapper;
import tuk.mento.common.vo.CustomMap;

@Mapper
public interface LoginMapper {
    CustomMap login(CustomMap param);
}
