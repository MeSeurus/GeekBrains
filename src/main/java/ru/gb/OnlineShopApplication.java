package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. Создать приложение «Hello world»,
 *    используя Spring Boot-инициализатор –
 *    https://start.spring.io/.
 * 2. Повторить п. 1, используя Boot-инициализатор вашей IDE.
 * 3. Попробуйте создать приложение «с нуля»,
 *    задав необходимые зависимости вручную.
 */

@SpringBootApplication
public class OnlineShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineShopApplication.class, args);

    }

}
