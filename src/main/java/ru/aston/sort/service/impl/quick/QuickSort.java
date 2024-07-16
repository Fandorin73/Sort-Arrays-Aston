package ru.aston.sort.service.impl.quick;

import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import ru.aston.sort.service.Sort;

import java.time.Duration;
import java.util.List;

public class QuickSort implements Sort {

    @Override
    public SortStatistic sort(List<Integer> list, UserEntity userEntity) {
        long duration = 1;
        return new SortStatistic(1111, duration, userEntity);
    }
}

