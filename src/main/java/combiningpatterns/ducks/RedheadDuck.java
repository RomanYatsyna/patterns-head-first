package combiningpatterns.ducks;

/**
 * Реализация утки.
 */
public class RedheadDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}