package tuk.mento.mapper.program;

import org.apache.ibatis.annotations.Mapper;
import tuk.mento.common.vo.CustomList;
import tuk.mento.common.vo.CustomMap;

@Mapper
public interface ProgramMapper {
    void registerProgram(CustomMap param);
    void registerProgramWeek(CustomMap param);
    CustomList<CustomMap> selectProgramList(String keyword);
    CustomList<CustomMap> selectProgramWeekList(int program_no);
}
