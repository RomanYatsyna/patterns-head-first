package proxy.gumballmonitor;

/**
 * Класс GumballMonitor получает местонахождение автомата, количество оставшихся шариков
 * и текущее состояние и выводит данные в виде небольшого отчета.
 */
public class GumballMonitor {
    GumballMachine machine;

    /**
     * Конструктор получает объект автомата и сохраняет его в переменной
     * экземпляра machine.
     */
    public GumballMonitor(GumballMachine machine) {
        this.machine = machine;
    }

    public void report() {
        System.out.println("Gumball Machine: " + machine.getLocation());
        System.out.println("Current inventory: " + machine.getCount() + " gumballs");
        System.out.println("Current state: " + machine.getState());
    }
}