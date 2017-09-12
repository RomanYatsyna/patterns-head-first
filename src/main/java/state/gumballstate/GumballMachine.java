package state.gumballstate;

/**
 * В данной реализации GumballMachine вместо статических целочисленных кодов
 * используются ссылки на объекты состояний.
 */
public class GumballMachine {
    // Все возможные состояния.
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    // Переменная экземпляра для хранения текущего состояния.
    State state;
    // В переменной хранится количество шариков.
    int count = 0;

    /**
     * Конструктор получает исходное количество шариков и сохраняет его в переменной.
     * Он также создает экземпляры State для всех состояний. Если количество шариков
     * установлено 0, то устанавливается состояние NoQuarterState.
     */
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    //Операции делегируются объекту текущего состояния.
    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    /**
     * Для метода dispense() в классе GumballMachine метод действия не нужен,
     * потому что это внутреннее действие, пользователь не может напрямую
     * потребовать, чтобы автомат выдал шарик. Однако метод dispense() для
     * объекта State вызывается из метода turnCrank().
     */
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    /**
     * Вспомогательный метод releaseBall() выдает шарик и уменьшает значение
     * переменной count.
     */
    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    int getCount() {
        return count;
    }

    void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; it's new count is: " + this.count);
        state.refill();
    }

    /**
     * Этот метод позволяет другим объектам (в частности, нашим объектам State)
     * перевести автомат в другое состояние.
     */
    void setState(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
