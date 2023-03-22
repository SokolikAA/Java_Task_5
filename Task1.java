// Реализуйте структуру телефонной книги с помощью HashMap,
// учитывая, что 1 человек может иметь несколько телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        Scanner scan = new Scanner(System.in);

        boolean book = true;

        while (book) {
            System.out.println();
            System.out.println("""
                    Меню:
                    1- Добавить номер в записную книгу,
                    2- Показать все контакты,
                    3- Найти контакт,
                    0- Выйти из записной книги.
                    Введите номер команды:\s""");
            String numberOperation = scan.nextLine();
            switch (numberOperation) {
                case "1" -> addContact(bookPhone, scan);
                case "2" -> showAllContacs(bookPhone);
                case "3" -> findContact(bookPhone, scan);
                case "0" -> {
                    book = false;
                    System.out.println("Всего доброго!");
                }
                default -> System.out.println("Неверная операция.");
            }
        }
    }

    public static void addContact(Map<String, ArrayList<Integer>> map, Scanner scanner) {
        ArrayList<Integer> phone_number = new ArrayList<>();
        System.out.println();
        System.out.print("Ведите имя: ");
        String name = scanner.nextLine();
        System.out.println();
        System.out.print("Введите номер телефона: ");
        Integer number = scanner.nextInt();
        if (!map.containsKey(name)) {
            phone_number.add(number);
            map.put(name, phone_number);
        } else {
            map.get(name).add(number);
        }
    }

    public static void showAllContacs(Map<String, ArrayList<Integer>> contacs) {
        System.out.println();
        for (String name : contacs.keySet()) {
            System.out.printf("Имя: " + name + "\n");
            ArrayList<Integer> phones = contacs.get(name);
            for (Integer phone : phones) {
                System.out.printf("Номер телефона: " + phone + "\n");
            }
            System.out.println();
        }
    }

    public static void findContact(Map<String, ArrayList<Integer>> map, Scanner scanner) {
        System.out.println();
        System.out.print("Ведите имя: ");
        String name = scanner.nextLine();
        System.out.printf("%s: %s", name, map.get(name));
    }

}
