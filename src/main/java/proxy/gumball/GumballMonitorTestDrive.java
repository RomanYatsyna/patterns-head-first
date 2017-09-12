package proxy.gumball;

import java.rmi.*;

/**
 * Тестовая программа для монитора (клиент).
 */
public class GumballMonitorTestDrive {

    /**
     * Местонахождение всех автоматов, которые мы собираемся отслеживать.
     */
    public static void main(String[] args) {
        // Создаем массив местонахождений.
        String[] location = {"rmi://santafe.mightygumball.com/gumballmachine",
                "rmi://boulder.mightygumball.com/gumballmachine",
                "rmi://seattle.mightygumball.com/gumballmachine"};

        if (args.length >= 0)
        {
            location = new String[1];
            location[0] = "rmi://" + args[0] + "/gumballmachine";
        }

        // Также создаем массив мониторов.
        GumballMonitor[] monitor = new GumballMonitor[location.length];


        // Теперь нужно получить заместителя для каждого автомата.
        for (int i=0;i < location.length; i++) {
            try {
                GumballMachineRemote machine =
                        (GumballMachineRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Перебираем автоматы и для каждого выводим отчет.
        for(int i=0; i < monitor.length; i++) {
            monitor[i].report();
        }
    }
}