package ru.aston.sort.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import ru.aston.sort.mapper.CustomSortStatisticMapper;
import ru.aston.sort.repository.SortStatisticRepository;
import ru.aston.sort.repository.UserRepository;
import ru.aston.sort.service.SortService;
import ru.aston.sort.service.UserService;
import ru.aston.sort.service.impl.bubble.EvenBubbleSort;
import ru.aston.sort.service.impl.bubble.OddBubbleSort;
import ru.aston.sort.service.impl.bubble.SimpleBubbleSort;
import ru.aston.sort.service.impl.quick.OddOrEvenQuickSort;
import ru.aston.sort.service.impl.quick.SimpleQuickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;


/**
 * Имплементация SortService.
 *
 * @author Team Aston
 */
@Service
@AllArgsConstructor
public class SortServiceImpl implements SortService {

    private final SortStatisticRepository sortStatisticRepository;
    private final UserRepository userRepository;
    private final StrategySort strategySort;
    private final CustomSortStatisticMapper customSortStatisticMapper;
    private final ReadFile readFile;
    private final UserService userService;

    @Override
    public SortStatisticDto simpleBubbleSort(List<Integer> list, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.sortAndSave(list, new SimpleBubbleSort(), user));
    }

    @Override
    public SortStatisticDto simpleBubbleSortFromFile(MultipartFile file, String userName) {
        return simpleBubbleSort(readFile.readIntegersFromFile(file), userName);
    }

    @Override
    public SortStatisticDto evenBubbleSort(List<Integer> list, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.sortAndSave(list, new EvenBubbleSort(), user));
    }

    @Override
    public SortStatisticDto evenBubbleSortFromFile(MultipartFile file, String userName) {
        return evenBubbleSort(readFile.readIntegersFromFile(file), userName);
    }

    @Override
    public SortStatisticDto oddBubbleSort(List<Integer> list, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.sortAndSave(list, new OddBubbleSort(), user));
    }

    @Override
    public SortStatisticDto oddBubbleSortFromFile(MultipartFile file, String userName) {
        return oddBubbleSort(readFile.readIntegersFromFile(file), userName);
    }

    @Override
    public SortStatisticDto evenQuickSort(List<Integer> list, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        OddOrEvenQuickSort evenQuickSort = new OddOrEvenQuickSort(isEven);

        return customSortStatisticMapper.toDto(strategySort.sortAndSave(list, evenQuickSort, user));
    }

    @Override
    public SortStatisticDto oddQuickSort(List<Integer> list, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        Predicate<Integer> isEven = n -> n % 2 != 0;
        OddOrEvenQuickSort oddQuickSort = new OddOrEvenQuickSort(isEven);

        return customSortStatisticMapper.toDto(strategySort.sortAndSave(list, oddQuickSort, user));
    }

    @Override
    public SortStatisticDto simpleQuickSort(List<Integer> list, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.sortAndSave(list, new SimpleQuickSort(), user));
    }

    @Override
    public SortStatisticDto quickSortFromFile(MultipartFile file, String userName) {
        UserEntity user = userService.getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.sortAndSave(readFile.readIntegersFromFile(file),
                new SimpleQuickSort(), user));
    }

    @Override
    public List<SortStatisticDto> getAllSort() {
        List<SortStatistic> sortStatistics = sortStatisticRepository.findAll();
        return customSortStatisticMapper.toDtoList(sortStatistics);
    }

    @Override
    public List<SortStatisticDto> getAllSortByUserName(String name) {
        List<SortStatistic> sortStatistics = sortStatisticRepository.getAllByUserEntityUserName(name);
        return customSortStatisticMapper.toDtoList(sortStatistics);
    }

    @Override
    public List<Integer> generateRandomArray(int size,int limit) {
        ArrayList<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(limit));
        }
        return list;
    }
}
