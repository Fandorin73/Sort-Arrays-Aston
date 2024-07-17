package ru.aston.sort.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для выода Swagger Статистики для пользователя.
 *
 * @author Team Aston
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SortStatisticsSwaggerDto implements DtoModel {
    private Integer permutations;
    private long sortingTimeMicroSeconds;

}
