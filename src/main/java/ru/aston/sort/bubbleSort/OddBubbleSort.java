package ru.aston.sort.bubbleSort;

import java.util.List;
import java.util.ArrayList;

public class OddBubbleSort {
    private int swapCount;

    public List<Integer> sort(List<Integer> numbers) {
        swapCount = 0;  // Сбрасываем счетчик перестановок
        List<Integer> sortedList = new ArrayList<>(numbers); // Создаем копию списка
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

        return sortedList;
    }

    public int getSwapCount() {
        return swapCount;
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
