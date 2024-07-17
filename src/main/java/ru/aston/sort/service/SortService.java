package ru.aston.sort.service;

import org.springframework.web.multipart.MultipartFile;
import ru.aston.sort.dto.SortStatisticDto;
import java.util.List;
import java.util.UUID;

/**
 * Сервис работы с сортировками.
 *
 * @author Team Aston
 */
public interface SortService {

    /**
     * Сортировка simpleBubbleSort
     *
     * @return - List<SortStatisticDto>
     */
    SortStatisticDto simpleBubbleSort(List<Integer> list, String userName);

    /**
     * Сортировка simpleBubbleSort из файла
     *
     * @return - List<SortStatisticDto>
     */
    SortStatisticDto simpleBubbleSortFromFile(MultipartFile file, String userName);

    /**
     * Сортировка evenBubbleSort
     *
     * @return - List<SortStatisticDto>
     */
    SortStatisticDto evenBubbleSort(List<Integer> list, String userName);

    /**
     * Сортировка evenBubbleSort из файла
     *
     * @return - List<SortStatisticDto>
     */
    SortStatisticDto evenBubbleSortFromFile(MultipartFile file, String userName);




    /**
     * Сортировка oddBubbleSort
     *
     * @return - List<SortStatisticDto>
     */
    SortStatisticDto  oddBubbleSort(List<Integer> list, String userName);

    /**
     * Сортировка oddBubbleSort из файла
     *
     * @return - List<SortStatisticDto>
     */
    SortStatisticDto oddBubbleSortFromFile(MultipartFile file, String userName);


    SortStatisticDto  oddQuickSort(List<Integer> list, String userName);

    SortStatisticDto  evenQuickSort(List<Integer> list, String userName);

    SortStatisticDto quickSortFromFile(MultipartFile file, String userName);
    SortStatisticDto simpleQuickSort(List<Integer> list, String userName);
    /**
     * Поиск всех сортировок
     *
     * @return - List<SortStatisticDto>
     */
    List<SortStatisticDto> getAllSort();

}
