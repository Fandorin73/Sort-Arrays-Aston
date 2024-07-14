package ru.aston.sort.mapper;

import java.util.List;

/**
 * Абстрактный интерфейс для всех мапперов.
 */
public interface MapperModel<E, D> {
    E toEntity(D dto);

    D toDto(E entity);

    List<D> toListDto(List<E> entity);

    List<E> toListEntity(List<D> entity);
}
