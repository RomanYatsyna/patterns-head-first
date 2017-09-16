package combiningpatterns.ducks;

/**
 * Реализация утки.
 */
public class RubberDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
