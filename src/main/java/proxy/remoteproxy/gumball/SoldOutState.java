package proxy.remoteproxy.gumball;

public class SoldOutState implements State {
    private static final long serialVersionUID = 2L;
    /* В каждой реализации State переменная GumballMachine помечается ключевым
     словом transient. Оно сообщает JVM, что это поле не сериализуется.*/
    transient GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }

    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    public String toString() {
        return "sold out";
    }
}