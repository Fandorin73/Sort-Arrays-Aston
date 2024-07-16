package ru.aston.sort.service.impl.quick;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class EvenQuickSort {
    private final SimpleQuickSort quickSort;

    public EvenQuickSort() {
        this.quickSort = new SimpleQuickSort();
    }

    public List<Integer> sort(List<Integer> data) {
        List<Integer> evenNumbers = data.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        data = quickSort.sort(evenNumbers);

        List<Integer> result = new ArrayList<>(data);
        Iterator<Integer> evenIterator = evenNumbers.iterator();

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) % 2 == 0 && evenIterator.hasNext()) {
                result.set(i, evenIterator.next());
            }
        }

        return result;
    }
}
