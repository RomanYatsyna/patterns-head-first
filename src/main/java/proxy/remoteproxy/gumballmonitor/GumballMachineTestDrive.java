package proxy.remoteproxy.gumballmonitor;

public class GumballMachineTestDrive {

    public static void main(String[] args) {
        int count = 0;
        // Местонахождение и исходное количество шариков передаются в командной строке.
        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        try {
            count = Integer.parseInt(args[1]);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        // Передаем параметры конструктору.
        GumballMachine gumballMachine = new GumballMachine(args[0], count);
        // Создание монитора с указанием автомата, для которого строится отчет.
        GumballMonitor monitor = new GumballMonitor(gumballMachine);


        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        // Чтобы получить отчет для автомата, вызываем метод report().
        monitor.report();
    }
}