package factory.factorymethod;

/**
 * Класс PizzaStore стал абстрактным
 */
public abstract class PizzaStore {
    /**
     * Метод orderPizza() понятия не имеет, какой из типов пиццы мы создаем,
     * он знает лишь то, что пиццу можно приготовить, выпечь, нарезать и упаковать.
     */
    public Pizza orderPizza(String type) {
        Pizza pizza;

        // Метод createPizza() теперь принадлежит PizzaStore, а не классу Фабрики
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // Фабричный метод стал абстрактным методом PizzaStore
    abstract Pizza createPizza(String type);
}
