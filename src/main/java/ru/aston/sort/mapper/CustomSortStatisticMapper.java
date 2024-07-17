package ru.aston.sort.mapper;

import org.springframework.stereotype.Component;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.entity.SortStatistic;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom Маппер для SortStatistics.
 *
 * @author Team Aston
 */
@Component
public class CustomSortStatisticMapper {

    /**
     * SortStatisticDto to.
     *
     * @author Team Aston
     */
    public SortStatisticDto toDto(SortStatistic sortStatistic) {
        SortStatisticDto dto = new SortStatisticDto();
        dto.setPermutations(sortStatistic.getPermutations());
        dto.setSortingTimeMills(sortStatistic.getSortingTime() / 1000);
        dto.setArrayResult(sortStatistic.getArrayResult());
        return dto;
    }

    /**
     * List SortStatisticDto toList.
     *
     * @author Team Aston
     */
    public List<SortStatisticDto> toDtoList(List<SortStatistic> sortStatisticList) {
        List<SortStatisticDto> dtoList = new ArrayList<>();
        for (SortStatistic sortStatistic:sortStatisticList) {
            SortStatisticDto dto = new SortStatisticDto();
            dto.setPermutations(sortStatistic.getPermutations());
            dto.setSortingTimeMills(sortStatistic.getSortingTime() / 1000);
            dto.setArrayResult(sortStatistic.getArrayResult());
            dtoList.add(dto);
        }
         return dtoList;
    }
}
