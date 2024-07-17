package ru.aston.sort.service;

import org.springframework.web.multipart.MultipartFile;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.dto.SortStatisticsSwaggerDto;

import java.util.List;

/**
 * Сервис работы с сортировками.
 *
 * @author Team Aston
 */
public interface SortService {

    /**
     * Сортировка simpleBubbleSort
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto simpleBubbleSort(List<Integer> list, String userName);

    /**
     * Сортировка simpleBubbleSort из файла
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto simpleBubbleSortFromFile(MultipartFile file, String userName);

    /**
     * Сортировка evenBubbleSort
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto evenBubbleSort(List<Integer> list, String userName);

    /**
     * Сортировка evenBubbleSort из файла
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto evenBubbleSortFromFile(MultipartFile file, String userName);

    /**
     * Сортировка oddBubbleSort
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto oddBubbleSort(List<Integer> list, String userName);

    /**
     * Сортировка oddBubbleSort из файла
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto oddBubbleSortFromFile(MultipartFile file, String userName);

    /**
     * Сортировка simpleQuickSort
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto simpleQuickSort(List<Integer> list, String userName);

    /**
     * Сортировка simpleQuickSort из файла
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto simpleQuickSortFromFile(MultipartFile file, String userName);

    /**
     * Сортировка oddQuickSort
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto evenQuickSort(List<Integer> list, String userName);

    /**
     * Сортировка evenQuickSort из файла
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto evenQuickSortFromFile(MultipartFile file, String userName);

    /**
     * Сортировка oddQuickSort
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto oddQuickSort(List<Integer> list, String userName);

    /**
     * Сортировка oddQuickSort из файла
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto oddQuickSortFromFile(MultipartFile file, String userName);

    /**
     * Поиск всех сортировок
     *
     * @return - SortStatisticDto
     */
    List<SortStatisticsSwaggerDto> getAllSort();

    /**
     * Поиск всех сортировок пользователя по имени
     *
     * @return - SortStatisticDto
     */
    List<SortStatisticsSwaggerDto> getAllSortByUserName(String name);

    /**
     * QuickSort Рандом
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto quickSortFromRand(int size, int limit, String userName);

    /**
     * BubbleSort Рандом
     *
     * @return - SortStatisticDto
     */
    SortStatisticDto bubbleSortFromRand(int size, int limit, String userName);

}
