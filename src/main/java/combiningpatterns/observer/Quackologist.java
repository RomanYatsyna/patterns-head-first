package combiningpatterns.observer;

/**
 * Наблюдатель должен реализовать интерфейс Observer, иначе его не удастся
 * зарегистрировать с QuackObservable.
 */
public class Quackologist implements Observer {
    /**
     * Метод выводит информацию о реализации Quackable, от которой поступило
     * оповещение.
     */
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked.");
    }

    public String toString() {
        return "Quackologist";
    }
}