package singleton.dcl;

/**
 * Потокобезопасная реализация Singleton, использующая Double-Checked Locking.
 *
 * Данная имплементация Singleton не дает гарантии корректной работы при
 * использовании версий Java, которые старше Java 5.
 */
public class Singleton {
    /* Ключемое слово volatile гарантирует, что параллельные программные потоки
     будут правильно работать с переменной uniqueInstance при ее инициализации
     экземпляром Singleton.*/
    private volatile static Singleton uniqueInstance;

    private Singleton() {}

    /**
     * Проверяем экземпляр, если он не существует - входим в блок synchronized.
     * Синхронизация выполняется только при первом вызове.
     * Внутри блока повторяем проверку, и если значение все еще равно null -
     * создаем экземпляр.
     */
    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}