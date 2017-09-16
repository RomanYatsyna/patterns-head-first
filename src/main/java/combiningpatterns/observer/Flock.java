package combiningpatterns.observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Комбинация должна реализовать тот же интерфейс, что и листовые элементы
 * (Quackable в этом примере).
 */
public class Flock implements Quackable {
    ArrayList<Quackable> ducks = new ArrayList<Quackable>();

    public void add(Quackable duck) {
        ducks.add(duck);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = ducks.iterator();
        while (iterator.hasNext()) {
            Quackable duck = (Quackable)iterator.next();
            duck.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator<Quackable> iterator = ducks.iterator();
        while (iterator.hasNext()) {
            Quackable duck = (Quackable)iterator.next();
            duck.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() { }

    public String toString() {
        return "Flock of Ducks";
    }
}