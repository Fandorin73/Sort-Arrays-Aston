package ru.aston.sort.service.impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class OddQuickSort {
    private final QuickSort quickSort;

    public OddQuickSort() {
        this.quickSort = new QuickSort();
    }

    public List<Integer> sort(List<Integer> data) {
        List<Integer> oddNumbers = data.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
        oddNumbers = quickSort.sort(oddNumbers);

        return oddNumbers;
    }
}
