package ru.aston.sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.sort.entity.SortStatistic;
import java.util.List;

/**
 * Хранилище SortStatistic.
 *
 * @author Team Aston
 */
public interface SortStatisticRepository extends JpaRepository<SortStatistic, String> {
    List<SortStatistic> getAllByUserEntityUserName(String userName);
}
