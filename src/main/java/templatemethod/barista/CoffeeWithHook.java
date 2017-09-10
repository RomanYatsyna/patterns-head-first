package templatemethod.barista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook {
    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    /**
     * Здесь мы переопределяем перехватчик и задаем нужную функциональность.
     */
    @Override
    public boolean customerWantsCondiments() {
        String answer = getUserInput();

        /* Предлагаем пользователю принять решение и возвращаем true/false в
         зависимости от полученных данных.*/
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * В этом фрагменте мы спрашиваем пользователя, нужно ли добавить в напиток
     * сахар/молоко. Входные данные читаются из командной строки.
     */
    private String getUserInput() {
        String answer = null;

        System.out.print("Would you like milk and sugar with your coffee (y/n)? ");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.err.println("IO error trying to read your answer");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
}
