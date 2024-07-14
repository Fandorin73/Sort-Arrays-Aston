package ru.aston.sort.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.aston.sort.dto.UserDto;
import ru.aston.sort.entity.UserEntity;

/**
 * Маппер для User.
 *
 * @author Team Aston
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends MapperModel<UserEntity, UserDto> {

}
