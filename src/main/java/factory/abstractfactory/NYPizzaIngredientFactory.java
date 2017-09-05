package factory.abstractfactory;

/**
 * Нью-Йоркская фабрика ингредиентов реализует общий интерфейс всех
 * фабрик ингредиентов.
 *
 * Для каждого ингредиента создается его версия для Нью-Йорка.
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    public Dough createDough() {
        return new ThinCrustDough();
    }

    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    public Veggies[] createVeggies() {
        /*Содержимое массива жестко фиксировано. Существуют и менее тривиальные решения
        но они не имеют отношения к изучению паттерна. */
        Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
        return veggies;
    }

    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    public Clams createClam() {
        return new FreshClams();
    }
}