package ru.aston.sort.mapper;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.entity.SortStatistic;

@Component
public class CustomSortStatisticMapper {
    public SortStatisticDto toDto(SortStatistic sortStatistic) {
        SortStatisticDto dto = new SortStatisticDto();
        dto.setPermutations(sortStatistic.getPermutations());
        dto.setSortingTimeMills(sortStatistic.getSortingTime() / 1000);
        dto.setArrayResult(sortStatistic.getArrayResult());
        return dto;
    }
}
