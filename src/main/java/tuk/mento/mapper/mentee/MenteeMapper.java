package tuk.mento.mapper.mentee;

import org.apache.ibatis.annotations.Mapper;
import tuk.mento.common.vo.CustomMap;

@Mapper
public interface MenteeMapper {
    void registerMentee(CustomMap param);
}
