package ru.aston.sort.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.aston.sort.dto.SortStatisticDto;
import ru.aston.sort.dto.UserDto;
import ru.aston.sort.entity.SortStatistic;
import ru.aston.sort.exception.ResourceNotFoundException;
import ru.aston.sort.mapper.CustomSortStatisticMapper;
import ru.aston.sort.mapper.UserMapper;
import ru.aston.sort.repository.UserRepository;
import ru.aston.sort.service.UserService;
import ru.aston.sort.entity.UserEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Имплементация UserService.
 *
 * @author Team Aston
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final StrategySort strategySort;
    private final CustomSortStatisticMapper customSortStatisticMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = mapper.toEntity(userDto);
        UserEntity saveUserEntity = userRepository.save(userEntity);
        return mapper.toDto(saveUserEntity);
    }

    @Override
    public UserDto getUserById(UUID userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User is not exist with given id: " + userId)
                );
        return mapper.toDto(userEntity);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserEntity> userEntitys = userRepository.findAll();
        return mapper.toListDto(userEntitys);
    }

    @Override
    public UserDto updateUser(UUID userId, UserDto updateUser) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User is not exist with given id: " + userId)
                );
        userEntity.setUserName(updateUser.getUserName());
        UserEntity updateUserObj = userRepository.save(userEntity);
        return mapper.toDto(updateUserObj);
    }

    public SortStatisticDto bubbleSort(List<Integer> list, String userName) {
        UserEntity user = getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.SortAndSave(list, new BubbleSort(), user));
    }

    public SortStatisticDto quickSort(List<Integer> list, String userName) {
        UserEntity user = getUserByUsernameOrCreateNew(userName);
        return customSortStatisticMapper.toDto(strategySort.SortAndSave(list, new QuickSort(), user));
    }

    public UserEntity getUserByUsernameOrCreateNew(String userName) {
        UserEntity userEntity = userRepository.findUserEntityByUserName(userName);

        if (userEntity == null) {
            userRepository.save(new UserEntity(userName));
            userEntity = userRepository.findUserEntityByUserName(userName);
        }
        return userEntity;
    }


    public SortStatisticDto bubbleSortFromFile(MultipartFile file, String userName) {
        return bubbleSort(readFromFile(file), userName);
    }

    public SortStatisticDto quickSortFromFile(MultipartFile file, String userName) {
        return quickSort(readFromFile(file), userName);
    }

    private List<Integer> readFromFile(MultipartFile file) { //TODO: to separate file
        List<Integer> numbers = new ArrayList<>();

        try {
            InputStream inputStream = file.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            List<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }


            for (String numStr : lines) {
                try {
                    int number = Integer.parseInt(numStr);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Incorrect data - only integers - one in one string.");
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException("Problem with file reading.");
        }
        return numbers;
    }

    @Override
    public void deleteUser(UUID userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User is not exist with given id: " + userId)
                );
        userRepository.deleteById(userId);
    }

    @Override
    public void deleteAllUser() {
        userRepository.deleteAll();
    }
}
