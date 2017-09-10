package templatemethod.sort;

import java.util.Arrays;

public class DuckSortTestDrive {
    public static void main(String[] args) {
        // Создаем массив объектов Duck.
        Duck[] ducks = {
                new Duck("Daffy", 8),
                new Duck("Dewey", 2),
                new Duck("Howard", 7),
                new Duck("Louie", 2),
                new Duck("Donald", 10),
                new Duck("Huey", 2)
        };

        // Выводим значения name и weight.
        System.out.println("Before sorting:");
        display(ducks);

        // Сортировка.
        Arrays.sort(ducks);

        // Выводим значения name и weight повторно.
        System.out.println("\nAfter sorting:");
        display(ducks);
    }

    public static void display(Duck[] ducks) {
        for (Duck d : ducks) {
            System.out.println(d);
        }
    }
}
