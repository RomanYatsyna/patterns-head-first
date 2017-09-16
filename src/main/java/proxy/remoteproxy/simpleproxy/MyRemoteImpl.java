package proxy.remoteproxy.simpleproxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Расширение UnicastRemoteObject - простейший способ создания объекта с
 * поддержкой удаленного доступа.
 *
 * Вы ОБЯЗАНЫ реализовать интерфейс удаленного доступа!
 *
 * ВАЖНО: перед выполнением программы необходимо программой rmic скомпилировать stut.
 * Для этого надо перейти в папку classes. Выполнить rmic proxy.remoteproxy.simpleproxy.MyRemoteImpl,
 * а затем запустить реестр (находясь все там же) командой rmiregistry.
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    /**
     * Конструктор суперкласса (UnicastRemoteObject) объявляет исключение, поэтому
     * вы должны определить конструктор как признак вызова небезопасного кода
     * (конструктора суперкласса).
     */
    protected MyRemoteImpl() throws RemoteException {
    }

    /**
     * Конечно, все методы интерфейса должны быть реализованы, но объявлять
     * RemoteException НЕ ОБЯЗАТЕЛЬНО.
     */
    @Override
    public String sayHello() {
        return "Server says 'Hello'!";
    }

    /**
     * Создайте удаленный объект и зарегистрируйте его в реестре RMI статическим
     * вызовом Naming.rebind(). Регистрируемое имя будет использоваться клиентами
     * для поиска объекта в реестре.
     */
    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
