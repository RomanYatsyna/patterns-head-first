package observer.custom;

public interface Subject {
    /**
     * Оба метода получают в аргументе реализацию Observer
     * (регистрируемый или исключаемый наблюдатель)
     */
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);

    /**
     * Этот метод вызывается для оповещения наблюдателей об изменении состояния субъекта
     */
    public void notifyObservers();
}
