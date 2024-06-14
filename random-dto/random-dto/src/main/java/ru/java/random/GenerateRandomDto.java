package ru.java.random;

import java.lang.reflect.Field;
import java.util.Random;

public class GenerateRandomDto {

    private final Random random = new Random();

    /**
     * Заполняет поля переданного DTO объекта случайными значениями.
     * @param dto объект DTO для заполнения
     * @param <T> тип объекта DTO
     * @return заполненный объект DTO
     */
    public <T> T fill(T dto) {
        if (dto == null) {
            return null;
        }
        // Обработка всех полей объекта
        for (Field field : dto.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                // Заполнение поля случайным значением, если оно равно null
                if (field.get(dto) == null) {
                    Object randomValue = getRandomValueForField(field);
                    field.set(dto, randomValue);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return dto;
    }

    /**
     * Возвращает случайное значение для указанного поля.
     * @param field поле для генерации случайного значения
     * @return случайное значение, соответствующее типу поля
     */
    private Object getRandomValueForField(Field field) {
        Class<?> type = field.getType();
        if (type.equals(String.class)) {
            return "RandomString" + random.nextInt(1000);
        } else if (type.equals(int.class) || type.equals(Integer.class)) {
            return random.nextInt(1000);
        } else if (type.equals(long.class) || type.equals(Long.class)) {
            return random.nextLong();
        } else if (type.equals(boolean.class) || type.equals(Boolean.class)) {
            return random.nextBoolean();
        } else if (type.equals(double.class) || type.equals(Double.class)) {
            return random.nextDouble();
        } else if (type.equals(float.class) || type.equals(Float.class)) {
            return random.nextFloat();
        } else if (type.equals(short.class) || type.equals(Short.class)) {
            return (short) random.nextInt(Short.MAX_VALUE + 1);
        } else if (type.equals(byte.class) || type.equals(Byte.class)) {
            return (byte) random.nextInt(Byte.MAX_VALUE + 1);
        } else if (!type.isPrimitive()) {
            try {
                // Рекурсивное заполнение вложенных DTO
                Object nestedDto = type.getDeclaredConstructor().newInstance();
                return fill(nestedDto);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    /**
     * Создает и заполняет новый экземпляр указанного класса DTO.
     * @param clazz класс DTO для создания и заполнения
     * @param <T> тип объекта DTO
     * @return заполненный объект DTO
     */
    public <T> T createAndFill(Class<T> clazz) {
        try {
            // Создание нового экземпляра DTO
            T dto = clazz.getDeclaredConstructor().newInstance();
            return fill(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
