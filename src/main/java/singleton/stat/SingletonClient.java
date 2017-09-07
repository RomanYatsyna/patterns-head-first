package singleton.stat;

/**
 * Тестовый класс для потокобезопасного Singleton
 */
public class SingletonClient {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.getDescription());
    }
}