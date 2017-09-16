package proxy.remoteproxy.gumball;

import java.rmi.*;

/**
 * Интерфейс удаленного доступа.
 * Все возвращаемые типы должны быть примитивными или Serializable.
 * Каждый метод должен инициировать RemoteException.
 */
public interface GumballMachineRemote extends Remote {
    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getState() throws RemoteException;
}