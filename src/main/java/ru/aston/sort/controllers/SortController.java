package ru.aston.sort.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.dto.UserDto;
import ru.aston.sort.service.SortService;
import ru.aston.sort.service.impl.SortServiceImpl;

import java.util.List;
import java.util.UUID;

/**
 * Controller для Статистики.
 *
 * @author Team Aston
 */
@RestController
@RequestMapping(path = "/sort")
@AllArgsConstructor
public class SortController {
    private final SortServiceImpl sortService;


    /**
     * Сортировка SimpleBubbleSort.
     *
     * @author Team Aston
     */
    @PostMapping(path = "/simpleBubbleSort/{username}")
    public SortStatisticDto simpleBubbleSort(@PathVariable("username") String username,
                                             @RequestBody List<Integer> list) {
        return sortService.simpleBubbleSort(list, username);
    }

    /**
     * Сортировка SimpleBubbleSort из файла.
     *
     * @author Team Aston
     */
    @PostMapping(value = "/simpleBubbleSort/fromFile/{username}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SortStatisticDto simpleBubbleSortFromFile(@PathVariable("username") String username,
                                                     @RequestParam("file") MultipartFile file) {
        return sortService.simpleBubbleSortFromFile(file, username);
    }


    /**
     * Сортировка EvenBubbleSort.
     *
     * @author Team Aston
     */
    @PostMapping(path = "/evenBubbleSort/{username}")
    public SortStatisticDto evenBubbleSort(@PathVariable("username") String username,
                                           @RequestBody List<Integer> list) {
        return sortService.evenBubbleSort(list, username);
    }

    /**
     * Сортировка EvenBubbleSort из файла.
     *
     * @author Team Aston
     */
    @PostMapping(value = "/evenBubbleSort/fromFile/{username}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SortStatisticDto evenBubbleSortFromFile(@PathVariable("username") String username,
                                                   @RequestParam("file") MultipartFile file) {
        return sortService.evenBubbleSortFromFile(file, username);
    }

    /**
     * Сортировка EvenBubbleSort.
     *
     * @author Team Aston
     */
    @PostMapping(path = "/oddBubbleSort/{username}")
    public SortStatisticDto oddBubbleSort(@PathVariable("username") String username,
                                           @RequestBody List<Integer> list) {
        return sortService.oddBubbleSort(list, username);
    }

    /**
     * Сортировка EvenBubbleSort из файла.
     *
     * @author Team Aston
     */
    @PostMapping(value = "/oddBubbleSort/fromFile/{username}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SortStatisticDto oddBubbleSortFromFile(@PathVariable("username") String username,
                                                   @RequestParam("file") MultipartFile file) {
        return sortService.oddBubbleSortFromFile(file, username);
    }

    /**
     * Сортировка EvenQuickSort.
     *
     * @author Team Aston
     */
    @PostMapping(path = "/evenQuickSort/{username}")
    public SortStatisticDto evenQuickSort(@PathVariable("username") String username,
                                          @RequestBody List<Integer> list) {
        return sortService.evenQuickSort(list, username);
    }

    /**
     * Сортировка OddQuickSort.
     *
     * @author Team Aston
     */
    @PostMapping(path = "/oddQuickSort/{username}")
    public SortStatisticDto oddQuickSort(@PathVariable("username") String username,
                                          @RequestBody List<Integer> list) {
        return sortService.oddQuickSort(list, username);
    }

    /**
     * Сортировка SimpleQuickSort.
     *
     * @author Team Aston
     */
    @PostMapping(path = "/simpleQuickSort/{username}")
    public SortStatisticDto simpleQuickSort(@PathVariable("username") String username,
                                         @RequestBody List<Integer> list) {
        return sortService.simpleQuickSort(list, username);
    }

    /**
     * Сортировка SimpleQuickSort из файла.
     *
     * @author Team Aston
     */
    @PostMapping(value = "/quickSort/fromFile/{username}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SortStatisticDto quickSortFromFile(@PathVariable("username") String username,
                                              @RequestParam("file") MultipartFile file) {
        return sortService.quickSortFromFile(file, username);
    }

    /**
     * Поиск всех сортировок.
     *
     * @author Team Aston
     */
    @GetMapping(path = "/getAllSort")
    public ResponseEntity<List<SortStatisticDto>> getAllSort() {
        List<SortStatisticDto> users = sortService.getAllSort();
        return ResponseEntity.ok(users);
    }
}
