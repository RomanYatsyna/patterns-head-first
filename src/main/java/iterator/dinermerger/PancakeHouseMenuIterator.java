package iterator.dinermerger;

import java.util.ArrayList;

/**
 * Конкретный итератор для коллекции PancakeHouseMenu. Реализует интерфейс
 * Iterator, который мы создали.
 */
public class PancakeHouseMenuIterator implements Iterator {
    ArrayList<MenuItem> items;
    int position = 0;

    public PancakeHouseMenuIterator(ArrayList<MenuItem> items) {
        this.items = items;
    }

    @Override
    public MenuItem next() {
        MenuItem item = items.get(position);
        position = position + 1;
        return item;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.size()) {
            return false;
        } else {
            return true;
        }
    }
}