package ru.java.dto;

/**
 * Класс NestedDto представляет вложенный DTO с полями description и isActive.
 */
public class NestedDto {

    private String description;
    private boolean isActive;

    // Геттеры
    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "NestedDto{" +
                "description='" + description + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
