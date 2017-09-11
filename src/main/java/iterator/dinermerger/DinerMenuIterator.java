package iterator.dinermerger;

/**
 * Конкретный итератор для коллекции DinerMenu. Реализует интерфейс
 * Iterator, который мы создали.
 */
public class DinerMenuIterator implements Iterator {
    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }

    /**
     * Так как для меню бистро выфделен массив максимального размера, нужно проверить не
     * только достижение границы массива, но и равенство следующего элемента null (признак
     * последнего элемента).
     */
    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
}
