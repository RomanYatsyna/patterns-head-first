package factory.simplefactory;

/**
 * Класс SimplePizzaFactory занимается исключительно созданием пиццы
 */
public class SimplePizzaFactory {
    /**
     * В фабрике определяется метод createPizz(), который будет использоваться
     * всеми клиентами для создания новых объектов
     */
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
