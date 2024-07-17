package ru.aston.sort.service;

import org.springframework.web.multipart.MultipartFile;
import ru.aston.sort.dto.SortStatisticDto;

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
     * @return - SortStatisticDto
     */
    SortStatisticDto oddQuickSort(List<Integer> list, String userName);

    /**
     * @return - SortStatisticDto
     */
    SortStatisticDto evenQuickSort(List<Integer> list, String userName);

    /**
     * @return - SortStatisticDto
     */
    SortStatisticDto quickSortFromFile(MultipartFile file, String userName);

    /**
     * @return - SortStatisticDto
     */
    SortStatisticDto simpleQuickSort(List<Integer> list, String userName);

    /**
     * Поиск всех сортировок
     *
     * @return - SortStatisticDto
     */
    List<SortStatisticDto> getAllSort();

    /**
     * Поиск всех сортировок пользователя по имени
     *
     * @return - SortStatisticDto
     */
    List<SortStatisticDto> getAllSortByUserName(String name);

    /**
     * Создает массив рандомных чисел
     *
     * @return -  Integer
     */
    List<Integer> generateRandomArray(int n, int limit);

}
