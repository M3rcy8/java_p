package ru.java.dto;

/**
 * Класс ExampleDto представляет основной DTO с полями name, age и nestedDto.
 */
public class ExampleDto {
    private String name;
    private Integer age;
    private NestedDto nestedDto;

    // Геттеры
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ExampleDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nestedDto=" + nestedDto +
                '}';
    }
}
