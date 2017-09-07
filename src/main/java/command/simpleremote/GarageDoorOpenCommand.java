package command.simpleremote;

/**
 * Реализация команды открытия гаражных дверей.
 * Класс команды должен реализовывать интерфейс Command.
 */
public class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.up();
    }
}
