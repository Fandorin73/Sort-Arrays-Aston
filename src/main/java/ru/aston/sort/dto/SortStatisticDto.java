package ru.aston.sort.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * DTO для Статистики.
 *
 * @author Team Aston
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SortStatisticDto implements DtoModel {
    private Integer permutations;
    private long sortingTimeMicroSeconds;
    private List<Integer> arrayResult;
}
