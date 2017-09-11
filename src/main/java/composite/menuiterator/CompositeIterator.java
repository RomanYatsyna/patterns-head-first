package composite.menuiterator;

import java.util.*;

/**
 * Перебирает элементы MenuItem в комбинации, а также следить за тем, чтобы в
 * перебор были включены все дочерние меню, а также их дочерние меню.
 *
 * Как и все итераторы, реализует интерфейс Iterator.
 */
public class CompositeIterator implements Iterator<MenuComponent> {
    Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();

    /**
     * В конструкторе передается итератор комбинации верхнего уровня. Мы сохраняем
     * его в стеке.
     */
    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    /**
     * Когда клиент запрашивает следующий элемент, мы сначала проверяем его существование
     * вызовом hasNext().
     * Если следующий элемент существует, мы извлекаем текущий итератор из стека и полу-
     * чаем следующий элемент.
     * Если компонент относится к классу Menu - обнаружена очередная комбинация, которую
     * необходимо включить в перебор, соответственно, мы заносим его в стек. В любом
     * случае метод возвращает компонент.
     */
    @Override
    public MenuComponent next() {
        if (hasNext()) {
            Iterator<MenuComponent> iterator = stack.peek();
            MenuComponent component = iterator.next();
            if (component instanceof Menu) {
                stack.push(component.createIterator());
            }
            return component;
        } else {
            return null;
        }
    }

    /**
     * Чтобы проверить наличие следующего компонента, мы проверяем, пуст ли стек.
     * Если стек не пуст, читаем из стека верхний итератор и проверяем, есть ли
     * в стеке следующий элемент. Если нет, метод извлекает компонент из стека
     * и рекурсивно вызывает hasNext().
     */
    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator<MenuComponent> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

	/*
	 * No longer needed as of Java 8
	 *
	 * (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 *
	public void remove() {
		throw new UnsupportedOperationException();
	}
	*/
}

