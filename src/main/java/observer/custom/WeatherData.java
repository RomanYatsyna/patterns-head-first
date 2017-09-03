package observer.custom;

import java.util.ArrayList;

/**
 * @author Roman Yatsyna {@literal <ryatsyna@at-consulting.ru>}
 */
public class WeatherData implements Subject {
    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    /**
     * Добавляем контейнер ArrayList для сохранения наблюдателей
     * и создаем его в конструкторе
     */
    public WeatherData() {
        observers = new ArrayList();
    }

    /**
     * Новые наблюдатели просто добавляются в конец списка
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }


    /**
     * Если наблюдатель хочет отменить регистрацию, мы просто
     * удаляем его из списка
     */
    @Override
    public void removeObserver(Observer o) {
        int i = observers.lastIndexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * Оповещение наблюдателей об изменении состояния через метод
     * update(), реализуемый всеми наблюдателями
     */
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * Оповечение наблюдателей о появлении новых данных
     */
    public void measurementsChanged() {
        notifyObservers();
    }

    /**
     * Сеттер для тестирования данных о метеостанции
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // Другие методы WeatherData
}

