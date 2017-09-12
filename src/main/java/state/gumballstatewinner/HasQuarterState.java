package state.gumballstatewinner;

import java.util.Random;

/**
 * Реализация конкретного состояния.
 */
public class HasQuarterState implements State {
    // Добавляем генератор случайных чисел с 10-процентной вероятностью выйгрыша.
    Random randomWinner = new Random(System.currentTimeMillis());
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    /**
     * Если покупателю повезло, и в автомате остался второй шарик, переходим в состояние
     * WinnerState; в противном случае переходим SoldState (как делалось ранее).
     */
    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (gumballMachine.getCount() > 1)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public void refill() { }

    public String toString() {
        return "waiting for turn of crank";
    }
}