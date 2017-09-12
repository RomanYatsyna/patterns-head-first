package state.gumballstate;

/**
 * Интерфейс всех состояний. Методы непосредственно соответствуют действиям,
 * которые могут выполняться с автоматом (и являются аналогами методов из
 * предыдущей версии).
 */
public interface State {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
    public void refill();
}
