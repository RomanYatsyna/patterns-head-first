package strategy;

public class DuckDecoy {
    QuackBehavior behavior;

    public void performQuack() {
        behavior.quack();
    }

    public void setBehavior(QuackBehavior behavior) {
        this.behavior = behavior;
    }
}
