package strategy.ducks;

/**
 * @author Roman Yatsyna {@literal <ryatsyna@at-consulting.ru>}
 */
public class MiniDucksSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

        DuckDecoy decoy = new DuckDecoy();
        decoy.setBehavior(new Quack());
        decoy.performQuack();
    }
}
