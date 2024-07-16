package ru.aston.sort.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

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
    private long sortingTimeMills;
    private List<Integer> arrayResult;
}
