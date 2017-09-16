package combiningpatterns.adapter;

/**
 * Реализация утки.
 */
public class DuckCall implements Quackable {
    @Override
    public void quack() {
        System.out.println("Kwak");
    }
}
