package strategy.ducks;

/**
 * @author Roman Yatsyna {@literal <ryatsyna@at-consulting.ru>}
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
