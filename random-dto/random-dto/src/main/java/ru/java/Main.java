package ru.java;

import ru.java.dto.ExampleDto;
import ru.java.random.GenerateRandomDto;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляра GenerateRandomDto
        GenerateRandomDto generateRandomDto = new GenerateRandomDto();

        // Создание и заполнение ExampleDto случайными значениями
        ExampleDto example = generateRandomDto.createAndFill(ExampleDto.class);

        // Вывод заполненного ExampleDto
        System.out.println(example);
    }
}

