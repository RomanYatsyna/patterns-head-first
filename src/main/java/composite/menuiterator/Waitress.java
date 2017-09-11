package composite.menuiterator;

import java.util.Iterator;

public class Waitress {
    MenuComponent allMenus;

    /**
     * Мы просто передаем компонент меню верхнего уровня - тот, который
     * содержит остальные меню. Мы назвали его allMenus.
     */
    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    /**
     * А чтобы вывести всю иерархию меню - все меню и все их елементы,
     * достаточно вызвать метод print() для меню верхнего уровня.
     */
    public void printMenu() {
        allMenus.print();
    }

    /**
     * Метод получает комбинацию allMenus и создает для нее итератор
     * (наш класс CompositeIterator).
     *
     * Для каждого элемента вызывается метод isVegetarian(), и если он
     * возвращает true - для элемента вызывается метод print().
     * Метод print() вызывается только для MenuItem и никогда для Menu.
     */
    public void printVegetarianMenu() {
        Iterator<MenuComponent> iterator = allMenus.createIterator();

        System.out.println("\nVEGETARIAN MENU\n----");
        // Перебор всех элементов комбинации.
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e) {}
        }
    }
}