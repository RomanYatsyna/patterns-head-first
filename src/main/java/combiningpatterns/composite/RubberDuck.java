package combiningpatterns.composite;

/**
 * Реализация утки.
 */
public class RubberDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }

    public String toString() {
        return "Rubber Duck";
    }
}
