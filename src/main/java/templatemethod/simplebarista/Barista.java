package templatemethod.simplebarista;

/**
 * Тестовый. Класс.
 *
 * В данном случае имеется дублирование кода в классах Coffee и Tea (boilWater() и
 * pourInCup()), а это верный признак того, что нужно менять архитектуру. Стоит
 * выделить схожие аспекты этиъ 2х классов в базовый класс.
 */
public class Barista {
    public static void main(String[] args) {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();
        System.out.println("Making tea...");
        tea.prepareRecipe();
        System.out.println("Making coffee...");
        coffee.prepareRecipe();
    }
}
