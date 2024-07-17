package ru.aston.sort.service.impl.quick;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import ru.aston.sort.service.Sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class OddOrEvenQuickSort implements Sort {
    private final SimpleQuickSort quickSort = new SimpleQuickSort();
    @Setter
    private Predicate<Integer> predicate;

    public OddOrEvenQuickSort(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    @Override
    public SortStatistic sort(List<Integer> unsortedList, UserEntity userEntity) {
        long startTime = System.nanoTime();
        List<Integer> evenList = unsortedList.stream().filter(predicate).collect(Collectors.toList());

        SortStatistic sortStatistic = quickSort.sort(evenList, userEntity);
        evenList = sortStatistic.getArrayResult();

        int swapCount = sortStatistic.getPermutations();
        List<Integer> result = new ArrayList<>(unsortedList);
        Iterator<Integer> evenIterator = evenList.iterator();

        for (int i = 0; i < unsortedList.size(); i++) {
            if (predicate.test(unsortedList.get(i)) && evenIterator.hasNext()) {
                swapCount++;
                result.set(i, evenIterator.next());
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        sortStatistic.setSortingTime(sortStatistic.getSortingTime() + duration);
        sortStatistic.setPermutations(swapCount);
        sortStatistic.setArrayResult(result);

        return sortStatistic;
    }
}
