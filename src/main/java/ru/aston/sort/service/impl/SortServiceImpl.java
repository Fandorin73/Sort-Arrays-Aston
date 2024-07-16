package ru.aston.sort.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import ru.aston.sort.mapper.CustomSortStatisticMapper;
import ru.aston.sort.mapper.SortStatisticsMapper;
import ru.aston.sort.repository.SortStatisticRepository;
import ru.aston.sort.repository.UserRepository;
import ru.aston.sort.service.SortService;
import ru.aston.sort.service.UserService;

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
    private final CustomSortStatisticMapper customSortStatisticMapper;
    private final ReadFile readFile;
    private final UserService userService;

    public SortStatisticDto bubbleSort(List<Integer> list, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.SortAndSave(list, new BubbleSort(), user));
    }

    public SortStatisticDto quickSort(List<Integer> list, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.SortAndSave(list, new QuickSort(), user));
    }

    public SortStatisticDto bubbleSortFromFile(MultipartFile file, String userName) {
        return bubbleSort(readFile.readIntegersFromFile(file), userName);
    }

    public SortStatisticDto quickSortFromFile(MultipartFile file, String userName) {
        return quickSort(readFile.readIntegersFromFile(file), userName);
    }

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
