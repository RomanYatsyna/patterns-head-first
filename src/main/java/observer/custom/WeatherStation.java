package observer.custom;

/**
 * Тестирование Weather Station
 */
public class WeatherStation {
    public static void main(String[] args) {
        // Сначала создадим объект WeatherData
        WeatherData weatherData = new WeatherData();

        // Создаем визуальный элемент
        CurrentConditionsDisplay currentConditionsDisplay =
                new CurrentConditionsDisplay(weatherData);

        // Иммитация новых погодных данных
        weatherData.setMeasurements(80, 60, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
