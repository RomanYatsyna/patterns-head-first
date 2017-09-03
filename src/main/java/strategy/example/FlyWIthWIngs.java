package strategy.example;

public class FlyWIthWIngs implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
