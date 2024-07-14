package ru.aston.sort.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.dto.UserDto;
import ru.aston.sort.service.SortService;
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
    private final SortService sortService;

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
    @GetMapping(path = "/getSortUserId/{user_id}")
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
