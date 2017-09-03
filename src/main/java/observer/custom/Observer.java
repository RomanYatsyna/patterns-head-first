package observer.custom;

/**
 * Интерфейс Observer реализуется всеми наблюдателями, таким образом
 * все наблюдатели должны реализовать метод update()
 */
public interface Observer {
    /**
     * В аргументах данные состояния, передаваемые наблюдателем
     * при изменении состоянии субъекта
     */
    public void update(float temp, float humidity, float pressure);
}
