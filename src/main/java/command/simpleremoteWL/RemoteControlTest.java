package command.simpleremoteWL;

/**
 * Класс для проверки реализации паттерна Команда. Вместо создания объектов
 * команд используются длям
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();

        remote.setCommand(light::on);
        remote.buttonWasPressed();
        remote.setCommand(garageDoor::up);
        remote.buttonWasPressed();
        remote.setCommand(garageDoor::lightOn);
        remote.buttonWasPressed();
        remote.setCommand(garageDoor::lightOff);
        remote.buttonWasPressed();
    }

}