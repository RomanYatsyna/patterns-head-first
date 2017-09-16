package combiningpatterns.observer;

/**
 * Все объекты Duck будут расширять этот интерфейс.
 *
 * Чтобы интерфейс QuackObservable был реализован всеми Quackable,
 * мы просто расширяем QuackObservable в этом интерфейсе.
 *
 */
public interface Quackable extends QuackObservable {
    public void quack();
}