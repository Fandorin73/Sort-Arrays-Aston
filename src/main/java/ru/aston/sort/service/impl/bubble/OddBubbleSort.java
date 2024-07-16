package ru.aston.sort.service.impl.bubble;

import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import ru.aston.sort.service.Sort;

import java.util.List;
import java.util.ArrayList;

public class OddBubbleSort implements Sort {
    @Override
    public SortStatistic sort(List<Integer> list, UserEntity userEntity) {
        long startTime = System.nanoTime();
        int swapCount;

        swapCount = 0;  // Сбрасываем счетчик перестановок
        List<Integer> sortedList = new ArrayList<>(list); // Создаем копию списка
        int n = sortedList.size();

        // Собираем все нечетные числа
        List<Integer> odds = new ArrayList<>();
        for (int number : sortedList) {
            if (isOdd(number)) {
                odds.add(number);
            }
        }

        // Сортируем нечетные числа
        for (int i = 0; i < odds.size() - 1; i++) {
            for (int j = 0; j < odds.size() - 1 - i; j++) {
                if (odds.get(j) > odds.get(j + 1)) {
                    int temp = odds.get(j);
                    odds.set(j, odds.get(j + 1));
                    odds.set(j + 1, temp);
                    swapCount++;  // Увеличиваем счетчик перестановок
                }
            }
        }

        // Вставляем отсортированные нечетные числа обратно в список
        int oddIndex = 0;
        for (int i = 0; i < n; i++) {
            if (isOdd(sortedList.get(i))) {
                sortedList.set(i, odds.get(oddIndex++));
            }
        }

        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        return new SortStatistic(swapCount, duration, userEntity, sortedList);
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
