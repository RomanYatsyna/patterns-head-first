package combiningpatterns.observer;

/**
 * Чтобы за Quackable можно было наблюдать, они должны реализовать
 * QuackObservable.
 */
public interface QuackObservable {
    /**
     * Метод регистрации наблюдателей. Любой объект, реализующий интерфейс
     * Observer, сможет получать оповещения.
     */
    public void registerObserver(Observer observer);

    public void notifyObservers();
}