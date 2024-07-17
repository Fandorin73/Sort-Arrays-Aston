package ru.aston.sort.service;

import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import java.util.List;

/**
 *
 *
 * @author Team Aston
 */
public interface Sort {
    SortStatistic sort(List<Integer> list, UserEntity userEntity);
}
