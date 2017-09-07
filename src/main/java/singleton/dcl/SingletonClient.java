package singleton.dcl;

/**
 * Тестовый класс для потокобезопасного Singleton
 */

public class SingletonClient {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
