package factory.abstractfactory;

/**
 * В ходе приготовления пиццы нам понадобится фабрика, поставляющая ингредиенты.
 * Соответственно, конструктору каждого класса пиццы передаетс объект фабрики,
 * ссылка на который сохраняется в переменной экземпляра.
 */
public class CheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    /**
     * Метод prepare() готовит пиццу, когда ему потребуется очередной ингредиент,
     * он запрашивает его у фабрики.
     */
    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}