package ru.aston.sort.service.impl.bubble;

import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import ru.aston.sort.service.Sort;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

public class EvenBubbleSort implements Sort {

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    @Override
    public SortStatistic sort(List<Integer> list, UserEntity userEntity) {
        long startTime = System.nanoTime();
        int swapCount = 0;  // Сбрасываем счетчик перестановок
        List<Integer> sortedList = new ArrayList<>(list); // Создаем копию списка
        int n = sortedList.size();

        // Собираем все четные числа
        List<Integer> evens = new ArrayList<>();
        for (int number : sortedList) {
            if (isEven(number)) {
                evens.add(number);
            }
        }

        // Сортируем четные числа
        for (int i = 0; i < evens.size() - 1; i++) {
            for (int j = 0; j < evens.size() - 1 - i; j++) {
                if (evens.get(j) > evens.get(j + 1)) {
                    int temp = evens.get(j);
                    evens.set(j, evens.get(j + 1));
                    evens.set(j + 1, temp);
                    swapCount++;  // Увеличиваем счетчик перестановок
                }
            }
        }

        // Вставляем отсортированные четные числа обратно в список
        int evenIndex = 0;
        for (int i = 0; i < n; i++) {
            if (isEven(sortedList.get(i))) {
                sortedList.set(i, evens.get(evenIndex++));
            }
        }

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        return new SortStatistic(swapCount, duration, userEntity, sortedList);
    }

}
