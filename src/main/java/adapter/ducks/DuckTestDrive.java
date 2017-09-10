package adapter.ducks;

/**
 * Тестовый код для проверки адаптера TurkeyAdapter.
 */
public class DuckTestDrive {
    public static void main(String[] args) {
        // Создаем объект Duck
        MallardDuck duck = new MallardDuck();

        // И объект Turkey.
        WildTurkey turkey = new WildTurkey();
        // Затем Turkey упаковывается в TurkeyAdapter и начинает выглядеть как Duck.
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        // Тестируем методы Turkey.
        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        // Теперь вызываем метод testDuck(), который получает объект Duck.
        System.out.println("\nThe Duck says...");
        testDuck(duck);

        // Важный тест: выдаем Turkey за Duck.
        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(turkeyAdapter);
    }

    /**
     * Метод testDuck() получает объект Duck и вызывает его методы quack() и fly().
     */
    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
