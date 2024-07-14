package ru.aston.sort.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

/**
 * DTO для User.
 *
 * @author Team Aston
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto implements DtoModel {

    private UUID userId;

    private String userName;
}
