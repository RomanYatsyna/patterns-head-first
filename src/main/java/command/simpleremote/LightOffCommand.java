package command.simpleremote;

/**
 * Реализация команды выключения света.
 * Класс команды должен реализовывать интерфейс Command.
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}
