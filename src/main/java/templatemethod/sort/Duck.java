package templatemethod.sort;

/**
 * При отсутствии реального субклассирования класс должен реализовать
 * интерфейс Comparable.
 */
public class Duck implements Comparable<Duck> {
    // Переменные экземпляра.
    String name;
    int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Объект Duck просто выводит значения переменных name
     * и weight.
     */
    public String toString() {
        return name + " weighs " + weight;
    }

    /**
     * Метод необходим для сортировки по weight.
     */
    @Override
    public int compareTo(Duck object) {
        Duck otherDuck = object;

        if (this.weight < otherDuck.weight) {
            return -1;
        } else if (this.weight == otherDuck.weight) {
            return 0;
        } else { // this.weight > otherDuck.weight
            return 1;
        }
    }
}