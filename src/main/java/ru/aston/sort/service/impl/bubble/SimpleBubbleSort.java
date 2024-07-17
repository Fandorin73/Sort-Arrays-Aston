package ru.aston.sort.service.impl.bubble;

import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import ru.aston.sort.service.Sort;
import java.util.ArrayList;
import java.util.List;


/**
 * SimpleBubbleSort
 *
 * @author Team Aston
 */
public class SimpleBubbleSort implements Sort {

    @Override
    public SortStatistic sort(List<Integer> list, UserEntity userEntity) {
        long startTime = System.nanoTime();
        int swapCount = 0;  // Сбрасываем счетчик перестановок
        List<Integer> sortedList = new ArrayList<>(list); // Создаем копию списка
        int n = sortedList.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (sortedList.get(j) > sortedList.get(j + 1)) {
                    int temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                    swapCount++;  // Увеличиваем счетчик перестановок
                }
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        return new SortStatistic(swapCount, duration, userEntity, sortedList);
    }

}
