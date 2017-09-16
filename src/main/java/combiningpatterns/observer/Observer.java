package combiningpatterns.observer;

/**
 * Интерфейс наблюдателя. Состоит из единственного метода update(),
 * которому передается реализация QuackObservable.
 */
public interface Observer {
    public void update(QuackObservable duck);
}
