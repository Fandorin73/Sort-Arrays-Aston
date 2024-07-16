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

    SortStatisticDto bubbleSort(List<Integer> list, String userName);

    SortStatisticDto quickSort(List<Integer> list, String userName);

    SortStatisticDto bubbleSortFromFile(MultipartFile file, String userName);

    SortStatisticDto quickSortFromFile(MultipartFile file, String userName);

    /**
     * Поиск всех сортировок
     *
     * @return - List<SortStatisticDto>
     */
    List<SortStatisticDto> getAllSort();

    /**
     * Поиск всех сортировок
     *
     * @param userId -User id
     * @return - List<SortStatisticDto>
     */
    List<SortStatisticDto> getSortByUserId(UUID userId);

    /**
     * SortBubble массив
     *
     * @return - List<Integer>
     */
    List<Integer> getArraySortBubble(List<Integer> array,UUID userId);

    /**
     * SortQuick  массив
     *
     * @return - List<Integer>
     */
    List<Integer> getArraySortQuick(List<Integer> array,UUID userId);
}
