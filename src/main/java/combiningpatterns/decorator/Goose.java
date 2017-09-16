package combiningpatterns.decorator;

/**
 * Класс Goose не реализует Quackable.
 */
public class Goose {
    public void honk() {
        System.out.println("Honk");
    }

    public String toString() {
        return "Goose";
    }
}