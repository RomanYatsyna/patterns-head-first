package factory.simplefactory;

/**
 * Модель PizzaStore простой Фабрики.
 */
public class PizzaStore {
    // Классу PizzaStore передается ссылка на SimplePizzaFactory
    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;
        /* Метод orderPizza() обращается к фабрике с запросом на
        создание объекта, передавая тип заказа, вызов оператора new
        заменяется вызовом метода create() объекта фабрики.*/
        pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
