package decorator.coffeshop;

/**
 * Абстрактный класс с двумя методами getDescription() и cost()
 * getDescription() уже реализован, а метод cost() надо реализовывать в субклассах
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
