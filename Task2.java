/**
 * Пусть дан список сотрудников:
 * Иван Иванов
 * Светлана Петрова
 * Кристина Белова
 * Анна Мусина
 * Анна Крутова
 * Иван Юрин
 * Петр Лыков
 * Павел Чернов
 * Петр Чернышов
 * Мария Федорова
 * Марина Светлова
 * Мария Савина
 * Мария Рыкова
 * Марина Лугова
 * Анна Владимирова
 * Иван Мечников
 * Петр Петин
 * Иван Ежов
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 * Отсортировать по убыванию популярности Имени.
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        Map<String, Integer> namePeople = new HashMap<>();
        String[] peoples = {
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        };
        countName(peoples, namePeople);
        Map<String, Integer> sortedNamePeople = new LinkedHashMap<>();
        int max = 1;
        for (int value : namePeople.values()) {
            if (value > max) {
                max = value;
            }
        }

        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : namePeople.entrySet()) {
                String name = entry.getKey();
                if (namePeople.get(name) == i) {
                    sortedNamePeople.put(name, namePeople.get(name));
                }
            }
        }
        for (var item : sortedNamePeople.entrySet()) {
            System.out.printf("%s: %d \n", item.getKey(), item.getValue());
        }
    }

    public static void countName(String[] people, Map<String, Integer> namePeople) {
        for (String person : people) {
            String name = person.split(" ")[0];
            if (namePeople.containsKey(name)) {
                namePeople.put(name, namePeople.get(name) + 1);
            } else {
                namePeople.put(name, 1);
            }
        }
    }
}
