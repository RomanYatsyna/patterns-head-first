package proxy.remoteproxy.gumball;

import java.io.*;

/**
 * Просто расширяем интерфейс Serializable - и теперь объект State во всех
 * субклассах может передаваться по сети.
 */
public interface State extends Serializable {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}