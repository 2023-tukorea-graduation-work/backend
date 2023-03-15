package tuk.mento.mapper.mento;

import org.apache.ibatis.annotations.Mapper;
import tuk.mento.common.vo.CustomMap;
import tuk.mento.domain.mento.Mento;

@Mapper
public interface MentoMapper {
    void registerMento(CustomMap param);
}
