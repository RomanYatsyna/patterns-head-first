package state.gumballstate;

/**
 * Реализация конкретного состояния.
 */
public class NoQuarterState implements State {
    GumballMachine gumballMachine;

    /**
     * Конструктору передается ссылка на объект автомата, которая сохраняется в переменной
     * экземпляра.
     */
    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    /**
     * Если в автомат брошена монета, вывести сообщение и перейти в состояние HasQuarterState.
     */
    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    // В остальных методах выводится соответствующее сообщение без смены состояния.
    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there's no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

    @Override
    public void refill() { }

    public String toString() {
        return "waiting for quarter";
    }
}
