package combiningpatterns.ducks;

/**
 * Реализация утки.
 */
public class MallardDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
