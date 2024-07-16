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

    @PostMapping(value ="/bubbleSort/fromFile/{username}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SortStatisticDto quickSortFromFile(@PathVariable("username") String username,
                                              @RequestParam("file") MultipartFile file) {
        return sortService.quickSortFromFile(file, username);
    }

    @PostMapping(value ="/quickSort/fromFile/{username}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SortStatisticDto bubbleSortFromFile(@PathVariable("username") String username,
                                              @RequestParam("file") MultipartFile file) {
        return sortService.bubbleSortFromFile(file, username);
    }

    @PostMapping(path = "/bubbleSort/{username}")
    public SortStatisticDto bubbleSort(@PathVariable("username") String username,
                                       @RequestBody List<Integer> list) {
        return sortService.bubbleSort(list, username);
    }

    @PostMapping(path = "/quickSort/{username}")
    public SortStatisticDto quickSort(@PathVariable("username") String username,
                                      @RequestBody List<Integer> list) {
        return sortService.quickSort(list, username);
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

    /**
     * Поиск сортировок User.
     *
     * @author Team Aston
     */
    @GetMapping(path = "/getSortUserId/{user_id}") //TODO :заменить id на username
    public ResponseEntity<List<SortStatisticDto>> getSortByUserId(@PathVariable(value = "user_id") UUID userId) {
        List<SortStatisticDto> sortStatistic = sortService.getSortByUserId(userId);
        return new ResponseEntity<>(sortStatistic, HttpStatus.OK);
    }

    /**
     * Сортировка Bubble массива , запись стаистики сортировки(времени и количества перестановок).
     *
     * @author Team Aston
     */
    @PostMapping(path = "/sortArrayBubble")
    public ResponseEntity<List<Integer>> sortArrayBubble(@RequestBody List<Integer> array,UUID userId) {

        List<Integer> arrayResult = sortService.getArraySortBubble(array,userId);
        return new ResponseEntity<>(arrayResult, HttpStatus.OK);
    }

    /**
     * Сортировка Quick массива , запись стаистики сортировки(времени и количества перестановок).
     *
     * @author Team Aston
     */
    @PostMapping(path = "/sortArrayQuick")
    public ResponseEntity<List<Integer>> sortArrayQuick(@RequestBody List<Integer> array,UUID userId) {
        List<Integer> arrayResult = sortService.getArraySortQuick(array,userId);
        return new ResponseEntity<>(arrayResult, HttpStatus.OK);
    }
}
