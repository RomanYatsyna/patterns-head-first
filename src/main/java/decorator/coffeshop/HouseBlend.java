package decorator.coffeshop;

/**
 * Другой класс напитка, от нас требуется лишь назначить подходящее описание
 * и вернуть правильную стоимость
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
