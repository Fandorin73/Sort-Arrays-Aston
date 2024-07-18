package ru.aston.sort.service.impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class EvenQuickSort {
    private final QuickSort quickSort;

    public EvenQuickSort() {
        this.quickSort = new QuickSort();
    }

    public List<Integer> sort(List<Integer> data) {
        List<Integer> evenNumbers = data.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        evenNumbers = quickSort.sort(evenNumbers);

        return evenNumbers;
    }
}
