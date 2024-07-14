package ru.aston.sort;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Aston Sort", version = "1.0", description = "Сортировка и сохранение статистики пользователя"))
public class SortApplication {

    public static void main(String[] args) {
        SpringApplication.run(SortApplication.class, args);
    }

}
