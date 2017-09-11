package composite.menuiterator;

import java.util.*;

/**
 * MenuComponent предоставляет реализации по умолчанию для всех методов.
 *
 * Так как одни методы имеют смысл тольк для MenuItem, а другие только для
 * Menu, реализация по умолчанию инициирует UnsupportedOperationException.
 * Если объект MenuItem или Menu не поддерживает операцию, ему не нужно
 * ничего делать - он просто наследует реализацию по-умолчанию.
 */
public abstract class MenuComponent {
    /* Группа комбинационных методов, т.е. методов для добавления, удаления
     и получения MenuComponent.*/
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
    /* Группа "методов операций", используемых MenuItem Некоторые из этих
     методов могут использоваться в Menu.*/
    public String getName() {
        throw new UnsupportedOperationException();
    }
    public String getDescription() {
        throw new UnsupportedOperationException();
    }
    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    /**
     * Метод включается в MenuComponent. Это означает, что он должен быть
     * реализован классами Menu и MenuItem, а вызов createIterator() для
     * комбинации будет распространяться на все дочерние элементы.
     */
    public abstract Iterator<MenuComponent> createIterator();

    /* Метод реализуется и в Menu, и в MenuItem, но мы представляем реализацию
     по-умолчанию.*/
    public void print() {
        throw new UnsupportedOperationException();
    }
}
