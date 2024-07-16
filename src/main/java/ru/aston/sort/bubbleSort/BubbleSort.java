package ru.aston.sort.bubbleSort;

import java.util.List;
import java.util.ArrayList;

public class BubbleSort {
    private int swapCount;

    public List<Integer> sort(List<Integer> numbers) {
        swapCount = 0;  // Сбрасываем счетчик перестановок
        List<Integer> sortedList = new ArrayList<>(numbers); // Создаем копию списка
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

        return sortedList;
    }

    public int getSwapCount() {
        return swapCount;
    }
}
