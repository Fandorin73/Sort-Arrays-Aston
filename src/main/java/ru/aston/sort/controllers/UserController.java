package ru.aston.sort.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.dto.UserDto;
import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.service.UserService;
import java.util.List;
import java.util.UUID;

/**
 * Controller для юзера.
 *
 * @author Team Aston
 */
@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;


    /**
     * Добавление User.
     *
     * @author Team Aston
     */
    @PostMapping(path = "/save")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     * Поиск по id User.
     *
     * @author Team Aston
     */
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") UUID userId) {
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    /**
     * Изменение User.
     *
     * @author Team Aston
     */
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") UUID userId,
                                              @RequestBody UserDto updatedUser) {
        UserDto userDto = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(userDto);
    }

    /**
     * Поиск всех User.
     *
     * @author Team Aston
     */
    @GetMapping(path = "/get")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    /**
     * Удаление User.
     *
     * @author Team Aston
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Удаление произожло успешно!");
    }

    /**
     * Удаление всех User.
     *
     * @author Team Aston
     */
    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteAllUser() {
        userService.deleteAllUser();
        return ResponseEntity.ok("Удаление произожло успешно!");
    }
}
