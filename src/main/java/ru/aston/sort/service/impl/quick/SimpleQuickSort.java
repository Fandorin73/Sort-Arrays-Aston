package ru.aston.sort.service.impl.quick;

import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import ru.aston.sort.repository.UserRepository;
import ru.aston.sort.service.Sort;

import java.util.Collections;
import java.time.Duration;
import java.util.List;

public class SimpleQuickSort implements Sort {
    private int swapCount = 0;

    @Override
    public SortStatistic sort(List<Integer> list, UserEntity userEntity) {
        long startTime = System.nanoTime();

        quickSort(list, 0, list.size() - 1);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        return new SortStatistic(swapCount, duration, userEntity, list);
    }

    private void quickSort(List<Integer> data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    private int partition(List<Integer> data, int low, int high) {
        int pivot = data.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (data.get(j) <= pivot) {
                i++;
                swapCount++;
                Collections.swap(data, i, j);
            }
        }
        swapCount++;
        Collections.swap(data, i + 1, high);
        return i + 1;
    }
}
