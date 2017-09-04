package decorator.coffeshop;

/**
 * Все классы конкретных напитков расширяют Beverage
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    /**
     * Просто возвращаем стоимость "базового" эспрессо
     */
    @Override
    public double cost() {
        return 1.99;
    }
}
