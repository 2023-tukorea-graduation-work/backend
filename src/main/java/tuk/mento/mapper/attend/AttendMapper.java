package tuk.mento.mapper.attend;

import org.apache.ibatis.annotations.Mapper;
import tuk.mento.common.vo.CustomList;
import tuk.mento.common.vo.CustomMap;

@Mapper
public interface AttendMapper {
    void registerAttend(CustomMap param);
    CustomList<CustomMap> selectMenteeInProgram(CustomMap param);
    CustomMap selectMentoProgramSchedule(CustomMap param);
}
