package singleton.stat;

/**
 * Безопасный при многопоточности Singleton, который не использует
 * синхронизированный метод getInstance().
 */
public class Singleton {
    /* Экземпляр Singleton создается в статическом инициализаторе.
     Потоковая безопасность этого кода гарантирована!*/
    private static Singleton uniqueInstance = new Singleton();

    private Singleton() {}

    // Экземпляр уже существует, просто возвращаем его.
    public static Singleton getInstance() {
        return uniqueInstance;
    }

    // simpleremoteWL useful methods here
    public String getDescription() {
        return "I'm a statically initialized Singleton!";
    }
}
