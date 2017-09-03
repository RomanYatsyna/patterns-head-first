package strategy.ducks;

/**
 * @author Roman Yatsyna {@literal <ryatsyna@at-consulting.ru>}
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
