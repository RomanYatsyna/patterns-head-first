package factory.abstractfactory;

/**
 * Для каждого ингридиента в интерфейсе определяется метод create().
 * Если бы в каждом экземпляре фабрики должны были присутствовать некие
 * общие "механизмы", так же можно было бы создать абстрактный класс.
 */
public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();

}