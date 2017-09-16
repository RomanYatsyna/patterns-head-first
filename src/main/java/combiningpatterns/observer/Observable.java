package combiningpatterns.observer;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * Инкапсулируем код регистрации и оповещения в классе Observable, который
 * реализует QuackObservable. В этом случае реальный код пишется только
 * один раз, а в QuackObservable достаточно включить код делегирования вызовов
 * вспомогательному классу Observable.
 */
public class Observable implements QuackObservable {
    ArrayList<Observer> observers = new ArrayList<Observer>();
    QuackObservable duck;

    /**
     * Конструктору передается объект QuackObservable, который используется
     * им для управления наблюдением.
     */
    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    /**
     * Регистрация наблюдателя.
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Код оповещения.
     */
    @Override
    public void notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer observer = iterator.next();
            observer.update(duck);
        }
    }

    public Iterator<Observer> getObservers() {
        return observers.iterator();
    }
}