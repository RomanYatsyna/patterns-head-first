package singleton.classic;

/**
 * Классический пример реализации уникального объекта
 */
public class Singleton {
    // Статическая переменная для хранения единственного экземпляра.
    private static Singleton uniqueInstance;

    /* Приватный конструктор: только Singleton может создавать экземпляры
    этого класса.*/
    private Singleton() {}

    // Метод getInstance() создает и возвращает экземпляр.
    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    // Другие полезные методы.
    public String getDescription() {
        return "I'm a classic Singleton!";
    }
}
