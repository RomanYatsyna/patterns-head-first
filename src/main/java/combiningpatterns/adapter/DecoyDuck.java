package combiningpatterns.adapter;

/**
 * Реализация утки.
 */
public class DecoyDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}