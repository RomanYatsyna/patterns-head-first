package combiningpatterns.adapter;

/**
 * + Адаптер.
 */
public class DuckSimulator {
    /**
     * Создаем объект и вызываем его метод simulate().
     */
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
    }

    /**
     * Создаем по экземпляру для каждой реализации Quackable и вызываем simulate()
     * для каждого из них.
     */
    void simulate() {
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator: With Goose Adapter");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
    }

    /**
     * Перегруженная версия метода simulate() имитирует одну утку.
     */
    void simulate(Quackable duck) {
        duck.quack();
    }
}
