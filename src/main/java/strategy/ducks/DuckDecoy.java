package strategy.ducks;

/**
 * @author Roman Yatsyna {@literal <ryatsyna@at-consulting.ru>}
 */
public class DuckDecoy {

    QuackBehavior behavior;

    public void performQuack() {
        behavior.quack();
    }

    public void setBehavior(QuackBehavior behavior) {
        this.behavior = behavior;
    }
}
