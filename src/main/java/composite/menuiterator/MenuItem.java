package composite.menuiterator;

import java.util.Iterator;

/**
 * Это класс листового узла на диаграмме классов паттерна Компоновщик, и
 * он реализует поведение элементов комбинации.
 */
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    /**
     * Конструктор получает название, описание и т.д. и сохраняет ссылки
     * на полученные данные. Он почти не отличается от конструктора в версии
     * реализации iterator.
     */
    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }

    /**
     * Этот метод отличается от предыдущей реализации. Мы переопредяем
     * метод print() класса MenuComponent(). Для MenuItem этот метод выводит
     * полное описание элемента меню: название описание, цену и признак
     * вегетарианского блюда.
     */
    @Override
    public void print() {
        System.out.print("  " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println("     -- " + getDescription());
    }
}