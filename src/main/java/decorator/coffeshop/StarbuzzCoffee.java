package decorator.coffeshop;

/**
 * Тестовый код для оформления заказов
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        // Заказываем эспрессо без дополнений, выводим описание и стоимость
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()
        + " $" + beverage.cost());

        /*
        Создаем объект DarkRoast. Заворачиваем в объект Mocha, потом во второй
        А потом в объект Whip.
         */
        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()
                + " $" + beverage2.cost());

        /*
        Создаем еще напиток с использованием докораторов
         */
        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription()
                + " $" + beverage3.cost());
    }
}
