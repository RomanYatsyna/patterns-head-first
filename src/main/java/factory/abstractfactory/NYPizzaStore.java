package factory.abstractfactory;

/**
 * Фабрика производит ингредиенты для всех пицц в нью-йоркском стиле
 *
 * Теперь при создании каждой пиццы задается фабрика, которая должна использоваться
 * для производства ингредиентов.
 *
 * Для каждого вида пиццы мы создаем новый экземпляр Pizza и передаем ему фабрику,
 * необходимую для производства ингредиентов.
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory =
                new NYPizzaIngredientFactory();

        if (item.equals("cheese")) {

            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");

        } else if (item.equals("veggie")) {

            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");

        } else if (item.equals("clam")) {

            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");

        } else if (item.equals("pepperoni")) {

            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");

        }
        return pizza;
    }
}