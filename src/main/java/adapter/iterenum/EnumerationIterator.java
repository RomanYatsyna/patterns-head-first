package adapter.iterenum;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Чтобы адаптер воспринимался клиентским кодом как итератов, он
 * реализует интерфейс Iterator.
 */
public class EnumerationIterator implements Iterator<Object> {
    Enumeration<?> enumeration;

    /**
     * Адаптируемый объект Enumeration сохраняется в переменной
     * (композиция).
     */
    public EnumerationIterator(Enumeration<?> enumeration) {
        this.enumeration = enumeration;
    }

    /**
     * Метод hasNext() передает управление методу hasMoreElements()
     * интерфейса Enumeration.
     */
    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    /**
     * Метод next() интерфейса Iterator передает управление методу
     * nextElement().
     */
    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    /**
     * Поддержать метод remove() интерфейса Iterator не удастся, поэтому
     * мы просто бросаем исключение.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
