package ru.aston.sort.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Duration;
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
public class SortStatisticDto {

    private UUID sortStatisticId;

    private Integer permutations;

    private Duration sortingTime;
}
