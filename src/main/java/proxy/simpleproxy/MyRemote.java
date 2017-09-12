package proxy.simpleproxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Интерфейс ДОЛЖЕН расширять java.rmi.Remote.
 */
public interface MyRemote extends Remote {
    /**
     * Все удаленные методы ДОЛЖНЫ объявлять RemoteException
     */
    public String sayHello() throws RemoteException;
}
