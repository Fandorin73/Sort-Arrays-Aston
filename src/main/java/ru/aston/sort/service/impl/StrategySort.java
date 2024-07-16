package ru.aston.sort.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;
import ru.aston.sort.repository.SortStatisticRepository;
import ru.aston.sort.service.Sort;

import java.util.List;

@Service
@AllArgsConstructor
public class StrategySort {
    private SortStatisticRepository sortStatisticRepository;

    public SortStatistic SortAndSave(List<Integer> list, Sort sort, UserEntity userEntity) {
        validation(list);
        SortStatistic sortedStatistic = sort.sort(list, userEntity);

        sortStatisticRepository.save(sortedStatistic);
        return sortedStatistic;
    }

    private void validation(List<Integer> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("You set null in sort method");
    }
}
