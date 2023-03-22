package tuk.mento.mapper.schedule;

import org.apache.ibatis.annotations.Mapper;
import tuk.mento.common.vo.CustomMap;

@Mapper
public interface ScheduleMapper {
    void registerSchedule(CustomMap param);
}
