package ru.aston.sort.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import ru.aston.sort.mapper.SortStatisticsMapper;
import ru.aston.sort.repository.SortStatisticRepository;
import ru.aston.sort.repository.UserRepository;
import ru.aston.sort.service.SortService;

import java.time.Duration;
import java.util.List;
import java.util.UUID;


/**
 * Имплементация SortService.
 *
 * @author Team Aston
 */
@Service
@AllArgsConstructor
public class SortServiceImpl implements SortService {

    private final SortStatisticRepository sortStatisticRepository;
    private final SortStatisticsMapper mapper;
    private final UserRepository userRepository;
    private final StrategySort strategySort;

    @Override
    public List<SortStatisticDto> getAllSort() {
        List<SortStatistic> sortStatistics = sortStatisticRepository.findAll();
        return mapper.toListDto(sortStatistics);
    }

    @Override
    public List<SortStatisticDto> getSortByUserId(UUID userId) {
        List<SortStatistic> sortStatistic = sortStatisticRepository.getAllByUserEntityUserId(userId);
        return mapper.toListDto(sortStatistic);
    }



    @Override
    public List<Integer> getArraySortBubble(List<Integer> array,UUID userId) {

        SortStatistic sortStatistic=new SortStatistic();

        sortStatistic.setPermutations(5);

        Duration duration = Duration.ofDays(1);
        sortStatistic.setSortingTime(duration);
        UserEntity userEntity = userRepository.getReferenceById(userId);
        sortStatistic.setUserEntity(userEntity);

        sortStatisticRepository.save(sortStatistic);
// не сохраняет
        List<Integer> result=array;
        return result;
    }

    @Override
    public List<Integer> getArraySortQuick(List<Integer> array,UUID userId) {

        List<Integer> result=array;

       // записать все в базу время, сетит

        return result;
    }
}
