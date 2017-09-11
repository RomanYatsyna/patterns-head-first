package iterator.dinermergercafe;

import java.util.Iterator;

/**
 * В данной реализации добавляется CafeMenu.
 *
 * Официантка получает итератор для каждой группы объектов, которые необходимо
 * перебирать. ArrayList имеет встроенный итератор, так же как и HashMap. У
 * Array нет своего итератора, поэтому мы создали собственный.
 * Теперь классу Waitress не надо беспокоиться о том, какая реализация использу-
 * ется в каждом конкретном случае - для перебора всегда используется тот же
 * интерфейс Iterator.
 */
public class Waitress {
    Menu pancakeHouseMenu;
    Menu dinerMenu;
    Menu cafeMenu;

    /**
     * CafeMenu передается вместе с другими меню в конструкторе, там оно
     * сохраняется в переменной экземпляра.
     */
    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }

    /**
     * Чтобы вывести меню, достаточно создать итератор и передать его printMenu().
     */
    public void printMenu() {
        Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
        Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();

        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
        System.out.println("\nDINNER");
        printMenu(cafeIterator);
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    public void printVegetarianMenu() {
        System.out.println("\nVEGETARIAN MENU\n---------------");
        printVegetarianMenu(pancakeHouseMenu.createIterator());
        printVegetarianMenu(dinerMenu.createIterator());
        printVegetarianMenu(cafeMenu.createIterator());
    }

    public boolean isItemVegetarian(String name) {
        Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
        if (isVegetarian(name, pancakeIterator)) {
            return true;
        }
        Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
        if (isVegetarian(name, dinerIterator)) {
            return true;
        }
        Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();
        if (isVegetarian(name, cafeIterator)) {
            return true;
        }
        return false;
    }


    private void printVegetarianMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            if (menuItem.isVegetarian()) {
                System.out.print(menuItem.getName() + ", ");
                System.out.print(menuItem.getPrice() + " -- ");
                System.out.println(menuItem.getDescription());
            }
        }
    }

    private boolean isVegetarian(String name, Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            if (menuItem.getName().equals(name)) {
                if (menuItem.isVegetarian()) {
                    return true;
                }
            }
        }
        return false;
    }
}
