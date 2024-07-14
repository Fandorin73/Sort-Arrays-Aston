package ru.aston.sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.sort.entity.UserEntity;

import java.util.UUID;

/**
 * Хранилище User.
 *
 * @author Team Aston
 */
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}
