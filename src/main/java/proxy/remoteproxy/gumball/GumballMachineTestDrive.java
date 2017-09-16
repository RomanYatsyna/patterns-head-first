package proxy.remoteproxy.gumball;

import java.rmi.*;

/**
 * ВАЖНО: Перед запуском необходимо в командной строке запустить rmiregistry.
 *
 * Служба регистрируется в реестре RMI, чтобы клиенты могли получить к ней
 * доступ.
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachineRemote gumballMachine = null;
        int count;
        // Местонахождение и количество шариков передается в командной строке.
        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        /* Создание экземпляра заключено в try/catch, потому что конструктор может
         инициировать исключения.
         Также добавляем вызов Naming.rebind(), который публикует заглушку под именем
         gumballmachine.*/
        try {
            count = Integer.parseInt(args[1]);

            gumballMachine =
                    new GumballMachine(args[0], count);
            Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}