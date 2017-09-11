package composite.menuiterator;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * Menu расширяет MenuComponent как и MenuItem. Menu может иметь любое
 * количество потомков типа MenuComponent, для их хранения используется
 * ArrayList.
 * <p>
 * Методы getPrice() или isVegetarian() не переопределяются, потому что
 * эти методы не имеют смысла для Menu. При попытке вызвать их для Menu
 * будет брошено исключение UnsupportedOperationException.
 */
public class Menu extends MenuComponent {
    Iterator<MenuComponent> iterator = null;
    ArrayList<MenuComponent> menuComponents = new ArrayList<>();
    String name;
    String description;

    /**
     * С каждым меню связывается название и описание.
     */
    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }


    /**
     * Здесь используется новый итератор - CompositeIterator. Он умеет пере-
     * бирать элементы любой комбинации.
     */
    @Override
    public Iterator<MenuComponent> createIterator() {
        if (iterator == null) {
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }

    /**
     * Мы используем итератор для перебора всех компонентов объекта Menu. Ими
     * могут быть другие объекты Menu или объекты MenuItem. Так как и Menu, и
     * MenuItem реализуют метод print(), мы просто вызываем метод print(), а
     * все остальное они сделают сами. Если в процессе перебора мы встретим
     * другой объект меню, его метод print() начнет новый перебор и т.д.
     */
    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            menuComponent.print();
        }
    }
}
