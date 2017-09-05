package factory.factorymethod;

/**
 * Класс NYPizzaStore расширяет PizzaStore, поэтому он
 * наследует метод orderPizza()
 */
public class NYPizzaStore extends PizzaStore {

    /**
     * createPizza() возвращает объект Pizza, а субкласс несет полную
     * ответственность за создаваемый конкретный экземпляр Pizza.
     * Так как в PizzaStore этот метод объявлен абстрактным, мы реализуем
     * его в наследнике.
     * Здесь создаются конкретные классы. Для каждого типа пиццы мы создаем
     * реализацию в нью-йоркском стиле.
     */
    @Override
    Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (item.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } else if (item.equals("clam")) {
            return new NYStyleClamPizza();
        } else if (item.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        } else return null;
    }
}