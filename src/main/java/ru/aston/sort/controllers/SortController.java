package ru.aston.sort.controllers;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.dto.SortStatisticsSwaggerDto;
import ru.aston.sort.service.impl.SortServiceImpl;
import java.util.List;

/**
 * Controller для Статистики.
 *
 * @author Team Aston
 */
@Tag(name = "Statistic Controller", description = "Принимает массив чисел или текстовый файл с числами от пользователя, сортирует их" +
        ", сохраняет статистику с данными о времени сортировки и количества перестановок. Просмотр статистики сортировок нужного пользователя")
@RestController
@RequestMapping(path = "/sort")
@AllArgsConstructor
@Validated
public class SortController {
    private final SortServiceImpl sortService;

    /**
     * Сортировка SimpleBubbleSort.
     *
     * @author Team Aston
     */
    @ApiResponse(responseCode = "200", description = "Bubble сортировка чисел",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SortStatisticDto.class)))
    @PostMapping(path = "/bubble/simple/{username}")
    public SortStatisticDto simpleBubbleSort(@PathVariable("username") String username,
                                             @RequestBody List<Integer> list) {
        return sortService.simpleBubbleSort(list, username);
    }

    /**
     * Сортировка SimpleBubbleSort из файла.
     *
     * @author Team Aston
     */
    @ApiResponse(responseCode = "200", description = "Bubble сортировка чисел из файла",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SortStatisticDto.class)))
    @PostMapping(value = "/bubble/simple-from-file/{username}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SortStatisticDto simpleBubbleSortFromFile(@PathVariable("username") String username,
                                                     @RequestParam("file") MultipartFile file) {
        return sortService.simpleBubbleSortFromFile(file, username);
    }

    /**
     * Сортировка EvenBubbleSort.
     *
     * @author Team Aston
     */
    @ApiResponse(responseCode = "200", description = "Bubble сортировка четных чисел",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SortStatisticDto.class)))
    @PostMapping(path = "/bubble/even/{username}")
    public SortStatisticDto evenBubbleSort(@PathVariable("username") String username,
                                           @RequestBody List<Integer> list) {
        return sortService.evenBubbleSort(list, username);
    }

    /**
     * Сортировка EvenBubbleSort из файла.
     *
     * @author Team Aston
     */
    @ApiResponse(responseCode = "200", description = "Bubble сортировка четных чисел из файла",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SortStatisticDto.class)))
    @PostMapping(value = "/bubble/even-from-file/{username}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SortStatisticDto evenBubbleSortFromFile(@PathVariable("username") String username,
                                                   @RequestParam("file") MultipartFile file) {
        return sortService.evenBubbleSortFromFile(file, username);
    }

    /**
     * Сортировка OddBubbleSort.
     *
     * @author Team Aston
     */
    @ApiResponse(responseCode = "200", description = "Bubble сортировка нечетных чисел",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SortStatisticDto.class)))
    @PostMapping(path = "/bubble/odd/{username}")
    public SortStatisticDto oddBubbleSort(@PathVariable("username") String username,
                                          @RequestBody List<Integer> list) {
        return sortService.oddBubbleSort(list, username);
    }

    /**
     * Сортировка OddBubbleSort из файла.
     *
     * @author Team Aston
     */
    @ApiResponse(responseCode = "200", description = "Bubble сортировка нечетных чисел из файла",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SortStatisticDto.class)))
    @PostMapping(value = "/bubble/odd-from-file/{username}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SortStatisticDto oddBubbleSortFromFile(@PathVariable("username") String username,
                                                  @RequestParam("file") MultipartFile file) {
        return sortService.oddBubbleSortFromFile(file, username);
    }

    /**
     * Сортировка SimpleQuickSort.
     *
     * @author Team Aston
     */
    @ApiResponse(responseCode = "200", description = "Quick сортировка чисел",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SortStatisticDto.class)))
    @PostMapping(path = "/quick/simple/{username}")
    public SortStatisticDto simpleQuickSort(@PathVariable("username") String username,
                                            @RequestBody List<Integer> list) {
        return sortService.simpleQuickSort(list, username);
    }

    /**
     * Сортировка SimpleQuickSort из файла.
     *
     * @author Team Aston
     */
    @ApiResponse(responseCode = "200", description = "Quick сортировка чисел из файла",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SortStatisticDto.class)))
    @PostMapping(value = "/quick/simple-from-ile/{username}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SortStatisticDto quickSortFromFile(@PathVariable("username") String username,
                                              @RequestParam("file") MultipartFile file) {
        return sortService.simpleQuickSortFromFile(file, username);
    }

    /**
     * Сортировка EvenQuickSort.
     *
     * @author Team Aston
     */
    @ApiResponse(responseCode = "200", description = "Quick сортировка четных чисел",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SortStatisticDto.class)))
    @PostMapping(path = "/quick/even/{username}")
    public SortStatisticDto evenQuickSort(@PathVariable("username") String username,
                                          @RequestBody List<Integer> list) {
        return sortService.evenQuickSort(list, username);
    }

    /**
     * Сортировка EvenQuickSort из файла.
     *
     * @author Team Aston
     */
    @ApiResponse(responseCode = "200", description = "Quick сортировка четных чисел из файла",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SortStatisticDto.class)))
    @PostMapping(value = "/quick/even-from-ile/{username}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SortStatisticDto evenQuickSortFromFile(@PathVariable("username") String username,
                                              @RequestParam("file") MultipartFile file) {
        return sortService.evenQuickSortFromFile(file, username);
    }

    /**
     * Сортировка OddQuickSort.
     *
     * @author Team Aston
     */
    @ApiResponse(responseCode = "200", description = "Quick сортировка нечетных чисел",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SortStatisticDto.class)))
    @PostMapping(path = "/quick/odd/{username}")
    public SortStatisticDto oddQuickSort(@PathVariable("username") String username,
                                         @RequestBody List<Integer> list) {
        return sortService.oddQuickSort(list, username);
    }

    /**
     * Сортировка OddQuickSort из файла.
     *
     * @author Team Aston
     */
    @ApiResponse(responseCode = "200", description = "Quick сортировка нечетных чисел из файла",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SortStatisticDto.class)))
    @PostMapping(value = "/quick/odd-from-ile/{username}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SortStatisticDto oddQuickSortFromFile(@PathVariable("username") String username,
                                                  @RequestParam("file") MultipartFile file) {
        return sortService.oddQuickSortFromFile(file, username);
    }

    /**
     * Поиск всех сортировок.
     *
     * @author Team Aston
     */
    @GetMapping(path = "/get-all-sort")
    public ResponseEntity<List<SortStatisticsSwaggerDto>> getAllSort() {
        List<SortStatisticsSwaggerDto> users = sortService.getAllSort();
        return ResponseEntity.ok(users);
    }

    /**
     * Поиск всех сортировок.
     *
     * @author Team Aston
     */
    @GetMapping(path = "/get-all-sort-by-user-name/{name}")
    public ResponseEntity<List<SortStatisticsSwaggerDto>> getAllSortByUserName(@RequestParam(value = "name", required = false) String name) {
        List<SortStatisticsSwaggerDto> array = sortService.getAllSortByUserName(name);
        return ResponseEntity.ok(array);
    }

    /**
     * QuickSort из случайного массива чисел, для которого пользователь задал размер и максимальное значение в массиве
     *
     * @author Team Aston
     */
    @GetMapping(path = "/quick-sort-from-file-random/size/{size}/limit/{limit}/username/{username}")
   public SortStatisticDto quickSortFromRand(@PathVariable("size") Integer size,
                                          @PathVariable("limit") Integer limit,
                                          @PathVariable("username") String username) {
        return sortService.quickSortFromRand(size, limit, username);
    }

    /**
     * BubbleSort из случайного массива чисел, для которого пользователь задал размер и максимальное значение в массиве
     *
     * @author Team Aston
     */
    @GetMapping(path = "/bubble-sort-from-file-random/size/{size}/limit/{limit}/username/{username}")
    public SortStatisticDto bubbleSortFromRand(@PathVariable("size") Integer size,
                                              @PathVariable("limit") Integer limit,
                                              @PathVariable("username") String username) {
        return sortService.bubbleSortFromRand(size, limit, username);
    }
}
