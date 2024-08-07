package ru.aston.sort.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

/**
 * Entity для юзера.
 *
 * @author Team Aston
 */
@Entity
@Table(name = "data_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements IEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(name = "user_name")
    private String userName;

    public UserEntity(String userName) {
        this.userName = userName;
    }
}
