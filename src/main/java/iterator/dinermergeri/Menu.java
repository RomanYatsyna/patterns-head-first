package iterator.dinermergeri;

import java.util.Iterator;

/**
 * Общий интерфейс для объектов меню. Имеет единственный метод, который
 * возвращает клиентам итератор для элементов меню.
 */
public interface Menu {
    public Iterator<MenuItem> createIterator();
}