package factory.factorymethod;

/**
 * Реализация пиццы ClamPizza в Chicago-стиле
 */
public class ChicagoStyleClamPizza extends Pizza {
    public ChicagoStyleClamPizza() {
        name = "Chicago Style Clam Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Frozen Clams from Chesapeake Bay");
    }

    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}