package proxy.remoteproxy.simpleproxy;

import java.rmi.Naming;

/**
 * Реализация клиента.
 */
public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go() {
        try {
            // Возвращается из реестра в виде типа Object, выполняем преобразование.
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");

            // Выглядит как обычный вызов метода.
            String s = service.sayHello();

            System.out.println(s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
