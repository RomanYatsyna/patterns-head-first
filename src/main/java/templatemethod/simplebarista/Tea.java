package templatemethod.simplebarista;

/**
 * Класс для приготовления чая.
 */
public class Tea {
    /**
     * Реализация очень похожа на реализацию в классе Coffee. Шаги 2 и 4
     * отличаются, но рецепт почти не изменился.
     */
    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    // Каждый из этих методов реализует один шаг алгоритма.

    public void boilWater() {
        System.out.println("Boiling water");
    }

    /**
     * Специфичный для Tea метод
     */
    public void steepTeaBag() {
        System.out.println("Steeping the tea");
    }

    /**
     * Специфичный для Tea метод
     */
    public void addLemon() {
        System.out.println("Adding Lemon");
    }

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
