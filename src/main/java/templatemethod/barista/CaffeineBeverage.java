package templatemethod.barista;

/**
 * Общий абстрактный класс, который отписывает приготовление и чая, и кофе,
 * шаги, которые отличались в simplebarista, приведены к общему названию и
 * сделаны абстрактными.
 */
public abstract class CaffeineBeverage {
    /**
     * Шаблонный метод.
     *
     * Этот метод объявлен final, потому что суперклассы не должны переопределять
     * этот метод.
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
