package ru.aston.sort.service.impl;

import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import ru.aston.sort.service.Sort;

import java.time.Duration;
import java.util.List;

public class BubbleSort implements Sort {
    @Override
    public SortStatistic sort(List<Integer> list, UserEntity userEntity) { //TODO: add adding of userEntity instead new UserEntity("Kate")
        Duration duration = Duration.ofMinutes(11);
        return new SortStatistic(1111, duration, userEntity);
    }
}
