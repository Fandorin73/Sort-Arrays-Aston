package ru.aston.sort.service;

import org.springframework.web.multipart.MultipartFile;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.dto.UserDto;
import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.entity.UserEntity;

import java.util.List;
import java.util.UUID;

/**
 * Сервис работы с User.
 *
 * @author Team Aston
 */
public interface UserService {

    UserEntity getUserByUsernameOrCreateNew(String userName);

    /**
     * Cоздать нового User
     *
     * @param userDto - данные User от пользователя
     * @return - User
     */
    UserDto createUser(UserDto userDto);

    /**
     * Поиск User по id
     *
     * @param userId - id User
     * @return - UserDto
     */
    UserDto getUserById(UUID userId);

    /**
     * Поиск всех User
     *
     * @return - UserDto
     */
    List<UserDto> getAllUser();

    /**
     * Изменение User по id
     *
     * @param userId        - id юзера
     * @param updateUserDto - User для изменения
     * @return - UserDto
     */
    UserDto updateUser(UUID userId, UserDto updateUserDto);

    /**
     * Удаление User по id
     *
     * @param userId - id User
     */
    void deleteUser(UUID userId);

    /**
     * Удаление всех User
     *
     */
    void deleteAllUser();
}
