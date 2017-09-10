package templatemethod.barista;

/**
 * Реализация паттерна Шаблонный Метод с перехватчиком (hook).
 */
public abstract class CaffeineBeverageWithHook {

    /**
     * Добавляем условную конструкцию, результат которой определяется
     * вызовом конкретного метода customerWantsCondiments(). Только если
     * вызов вернет true, мы вызываем addCondiments().
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * Метод с (почти) пустой реализацией по умолчанию: просто возвращает
     * true и не делает ничего больше.
     * Перехватчик: субкласс может переопределить этот метод, но не обязан
     * этого делать.
     */
    boolean customerWantsCondiments() {
        return true;
    }
}
