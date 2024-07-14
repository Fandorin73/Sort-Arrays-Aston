package ru.aston.sort.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.entity.SortStatistic;

/**
 * Маппер для SortStatistics.
 *
 * @author Team Aston
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SortStatisticsMapper extends MapperModel<SortStatistic, SortStatisticDto>{
}
