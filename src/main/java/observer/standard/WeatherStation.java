package observer.standard;

/**
 * Тестирование Weather Station
 */
public class WeatherStation {
    public static void main(String[] args) {
        // Сначала создадим объект WeatherData
        WeatherData weatherData = new WeatherData();

        // Создаем визуальный элемент
        CurrentConditionsDisplay currentConditionsDisplay2 =
                new CurrentConditionsDisplay(weatherData);

        // Иммитация новых погодных данных
        weatherData.setMeasurements(80, 62, 30.4f);
        weatherData.setMeasurements(82, 72, 29.2f);
        weatherData.setMeasurements(78, 92, 29.2f);
    }
}
