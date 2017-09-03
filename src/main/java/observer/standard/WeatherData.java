package observer.standard;

import java.util.Observable;

/**
 * Наследуется от Observable! Суперкласс берет на себя все управление
 * наблюдателями, поэтому здесь нет кода регистрации, добавления и оповещения
 * как в кастомной реализации
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    /**
     * Теперь структура для хранения наблюдателей не нужна
     */
    public WeatherData() {}

    /**
     * Перед вызовом notifyObservers() необходимо вызвать setChanged()
     */
    public void measurementChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    /**
     * Эти методы будут использоваться наблюдателями для получения состояния объекта WeatherData
     */
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}