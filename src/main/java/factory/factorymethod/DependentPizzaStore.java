package factory.factorymethod;

/**
 * Некорректный пример без использования Фабричного Метода.
 * Эта версия PizzaStore зависит от всех субклассов, потому что она непосредственно
 * создает их экземпляры. Если реализация одного из этих классов изменится, возможно,
 * нам придется вносить изменения в PizzaStore.
 * Так как любые измененения в конкретных реализациях влияют на PizzaStore, мы говорим,
 * что PizzaStore "зависит" от реализаций.
 * Каждая новая разновидность пиццы создает новую зависимость для PizzaStore.
 *
 * Главный недостаток этой версии заключается в том, что она зависит от всех классов
 * пиццы из-за явного создания экземпляров конкретных типов в методе orderPizza().
 * Хотя мы и создали абстракцию Pizza, в коде кодируются конкретные типы пиццы, поэтому
 * абстракция особой пользы не приносит.
 */
public class DependentPizzaStore {
    public Pizza createPizza(String style, String type) {
        Pizza pizza = null;
        if (style.equals("NY")) {
            if (type.equals("cheese")) {
                pizza = new NYStyleCheesePizza();
            } else if (type.equals("veggie")) {
                pizza = new NYStyleVeggiePizza();
            } else if (type.equals("clam")) {
                pizza = new NYStyleClamPizza();
            } else if (type.equals("pepperoni")) {
                pizza = new NYStylePepperoniPizza();
            }
        } else if (style.equals("Chicago")) {
            if (type.equals("cheese")) {
                pizza = new ChicagoStyleCheesePizza();
            } else if (type.equals("veggie")) {
                pizza = new ChicagoStyleVeggiePizza();
            } else if (type.equals("clam")) {
                pizza = new ChicagoStyleClamPizza();
            } else if (type.equals("pepperoni")) {
                pizza = new ChicagoStylePepperoniPizza();
            }
        } else {
            System.out.println("Error: invalid type of pizza");
            return null;
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}