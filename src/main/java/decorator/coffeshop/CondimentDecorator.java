package decorator.coffeshop;

/**
 * Объекты должны быть взаимозаменяемы, поэтому расширяем класс Beverage
 */
public abstract class CondimentDecorator extends Beverage {
    @Override
    public abstract String getDescription();
}
