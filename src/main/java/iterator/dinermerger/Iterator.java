package iterator.dinermerger;

/**
 * Создаем общий для конкретных итераторов интерфейс.
 */
public interface Iterator {
    boolean hasNext();

    MenuItem next();
}
