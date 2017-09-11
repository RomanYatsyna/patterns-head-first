package iterator.transition;

import java.util.*;

/**
 * В данной реализации усовершенствован пример кода Waitress
 */
public class Waitress {
    ArrayList<Menu> menus;

    /**
     * Передаем коллекцию с элементами Menu.
     */
    public Waitress(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    /**
     * Перебираем объекты меню, передавая итератор каждого объекта
     * перегруженному методу printMenu().
     */
    public void printMenu() {
        Iterator<?> menuIterator = menus.iterator();
        while (menuIterator.hasNext()) {
            Menu menu = (Menu) menuIterator.next();
            printMenu(menu.createIterator());
        }
    }

    void printMenu(Iterator<?> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
}