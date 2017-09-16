package combiningpatterns.observer;

/**
 * Реализация утки.
 * Каждая реализация Quackable содержит объект Observable.
 */
public class DecoyDuck implements Quackable {
    Observable observable;

    public DecoyDuck() {
        observable = new Observable(this);
    }

    /**
     * Наблюдатели оповещаются о вызовах quack().
     */
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    public String toString() {
        return "Decoy Duck";
    }
}