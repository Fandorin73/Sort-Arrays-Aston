package ru.aston.sort.service.impl.bubble;

import lombok.Setter;
import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import ru.aston.sort.service.Sort;
import ru.aston.sort.service.impl.quick.SimpleQuickSort;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * EvenBubbleSort
 *
 * @author Team Aston
 */
public class OddOrEvenBubbleSort implements Sort {
    private final SimpleBubbleSort BubbleSort = new SimpleBubbleSort();
    @Setter
    private Predicate<Integer> predicate;

    public OddOrEvenBubbleSort(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    @Override
    public SortStatistic sort(List<Integer> unsortedList, UserEntity userEntity) {
        long startTime = System.nanoTime();
        List<Integer> evens = unsortedList.stream().filter(predicate).collect(Collectors.toList());

        SortStatistic sortStatistic = BubbleSort.sort(evens, userEntity);
        evens = sortStatistic.getArrayResult();

        int swapCount = sortStatistic.getPermutations();
        List<Integer> sortedList = new ArrayList<>(unsortedList);

        // Вставляем отсортированные четные числа обратно в список
        int evenIndex = 0;
        for (int i = 0; i < unsortedList.size(); i++) {
            if (predicate.test(sortedList.get(i))) {
                swapCount++;
                sortedList.set(i, evens.get(evenIndex++));
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        return new SortStatistic(swapCount, sortStatistic.getSortingTime() + duration, userEntity, sortedList);
    }

}
