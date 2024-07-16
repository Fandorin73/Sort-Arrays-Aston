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
import ru.aston.sort.service.impl.bubble.EvenBubbleSort;
import ru.aston.sort.service.impl.bubble.OddBubbleSort;
import ru.aston.sort.service.impl.bubble.SimpleBubbleSort;
import ru.aston.sort.service.impl.quick.QuickSort;

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

    public SortStatisticDto simpleBubbleSort(List<Integer> list, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.SortAndSave(list, new SimpleBubbleSort(), user));
    }

    public SortStatisticDto simpleBubbleSortFromFile(MultipartFile file, String userName) {
        return simpleBubbleSort(readFile.readIntegersFromFile(file), userName);
    }

    public SortStatisticDto evenBubbleSort(List<Integer> list, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.SortAndSave(list, new EvenBubbleSort(), user));
    }

    public SortStatisticDto evenBubbleSortFromFile(MultipartFile file, String userName) {
        return evenBubbleSort(readFile.readIntegersFromFile(file), userName);
    }

    public SortStatisticDto oddBubbleSort(List<Integer> list, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.SortAndSave(list, new OddBubbleSort(), user));
    }

    public SortStatisticDto oddBubbleSortFromFile(MultipartFile file, String userName) {
        return oddBubbleSort(readFile.readIntegersFromFile(file), userName);
    }




    public SortStatisticDto quickSort(List<Integer> list, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.SortAndSave(list, new QuickSort(), user));
    }



    public SortStatisticDto quickSortFromFile(MultipartFile file, String userName) {
        return quickSort(readFile.readIntegersFromFile(file), userName);
    }

    @Override
    public List<SortStatisticDto> getAllSort() {
        List<SortStatistic> sortStatistics = sortStatisticRepository.findAll();
        return mapper.toListDto(sortStatistics);
    }

}
