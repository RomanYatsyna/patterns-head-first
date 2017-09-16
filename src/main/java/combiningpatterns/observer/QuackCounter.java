package combiningpatterns.observer;

/**
 * Счетчик для уток. Необходимо реализовать целевой интерфейс.
 */
public class QuackCounter implements Quackable {
    // Переменная для хранения декорируемого объекта.
    Quackable duck;
    // Для подсчета используется статическая переменная.
    static int numberOfQuacks;

    /**
     * В конструкторе получаем ссылку на декорируемую реализацию
     * Quackable.
     */
    public QuackCounter (Quackable duck) {
        this.duck = duck;
    }

    /**
     * Вызов делегируется реализации Quackable.
     */
    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    /**
     * Получаем количество по счетчику.
     */
    public static int getQuacks() {
        return numberOfQuacks;
    }

    @Override
    public void registerObserver(Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }

    public String toString() {
        return duck.toString();
    }
}