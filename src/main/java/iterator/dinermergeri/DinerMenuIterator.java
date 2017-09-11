package iterator.dinermergeri;

import java.util.Iterator;

/**
 * Поскольку массивы не имеют встроенной поддержки итераторов, нам необходимо
 * реализовать класс DinerMenuIterator, реализующий java.util.Iterator.
 */
public class DinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] list;
    int position = 0;

    public DinerMenuIterator(MenuItem[] list) {
        this.list = list;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = list[position];
        position = position + 1;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        if (position >= list.length || list[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Теперь мы должны реализовать метод remove(). Так как в данном случае используется
     * массив фиксированного размера, при вызове remove() элементы просто сдвигаются на одну
     * позицию.
     */
    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException
                    ("You can't remove an item until you've done at least one next()");
        }
        if (list[position - 1] != null) {
            for (int i = position - 1; i < (list.length - 1); i++) {
                list[i] = list[i + 1];
            }
            list[list.length - 1] = null;
        }
    }
}