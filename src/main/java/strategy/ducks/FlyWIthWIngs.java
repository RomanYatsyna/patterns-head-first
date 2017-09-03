package strategy.ducks;

/**
 * @author Roman Yatsyna {@literal <ryatsyna@at-consulting.ru>}
 */
public class FlyWIthWIngs implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
