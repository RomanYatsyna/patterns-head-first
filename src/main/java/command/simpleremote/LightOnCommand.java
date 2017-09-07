package command.simpleremote;

/**
 * Реализация команды для включения света.
 * Класс команды должен реализовывать интерфейс Command.
 */
public class LightOnCommand implements Command {
    Light light;

    /**
     * В переменной light конструктору передается конкретный объект,
     * которым будет управлять команда (допустим, освещение в гостинной).
     * При вызове execute() получателем запроса будет объект light.
     */
    public LightOnCommand(Light light) {
        this.light = light;
    }

    /**
     * Метод execute() вызывает метод on() объекта-получателя (то
     * есть осветительной системы).
     */
    @Override
    public void execute() {
        light.on();
    }
}
