package ru.aston.sort.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Entity для статистики.
 *
 * @author Team Aston
 */
@Entity
@Table(name = "data_sort_statistics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortStatistic implements IEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID sortStatisticId;

    @Column(name = "permutations")
    private Integer permutations;

    @Column(name = "sorting_time")
    private Long sortingTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = true)
    private UserEntity userEntity;

    public SortStatistic(Integer permutations, Long sortingTime, UserEntity userEntity, List<Integer> arrayResult) {
        this.permutations = permutations;
        this.sortingTime = sortingTime;
        this.userEntity = userEntity;
        this.arrayResult = arrayResult;
    }

    @Transient
    private List<Integer> arrayResult;

    public SortStatistic(Integer permutations, Long sortingTime, UserEntity userEntity) {
        this.permutations = permutations;
        this.sortingTime = sortingTime;
        this.userEntity = userEntity;
    }
}
