package combiningpatterns.composite;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * Комбинация должна реализовать тот же интерфейс, что и листовые элементы
 * (Quackable в этом примере).
 */
public class Flock implements Quackable {
    // Каждая стая (Flock) содержит ArrayList для хранения реализаций Quackable.
    ArrayList<Quackable> quackers = new ArrayList<Quackable>();

    /**
     * Метод включает реализацию Quackable в Flock.
     */
    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    /**
     * Перебираем все элементы Flock и для каждого вызываем  quack().
     */
    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.quack();
        }
    }

    public String toString() {
        return "Flock of Quackers";
    }
}