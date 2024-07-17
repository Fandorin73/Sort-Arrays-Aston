package ru.aston.sort;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SortApplication
 *
 * @author Team Aston
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Sort-Arrays-Aston", version = "1.0", description = "Сортировка чисел и сохранение статистики пользователя"))
public class SortApplication {

    public static void main(String[] args) {
        SpringApplication.run(SortApplication.class, args);
    }

}
