package singleton.threadsafe;

/**
 * Реализация Singleton, безопасная при использовании многопоточности.
 * Метод getInstance() делается синхронизированным.
 */
public class Singleton {
    private static Singleton uniqueInstance;

    // simpleremoteWL useful instance variables here

    private Singleton() {}

    /* Включая в объявление getInstance() ключевое слово synchronized,
    мы заставляем каждый поток дождаться своей очереди для входа в него.
    Иначе говоря, два потока не смогут войти в метод одновременно.*/
    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    // Другие полезные методы.
    public String getDescription() {
        return "I'm a thread safe Singleton!";
    }
}