package command.simpleremote;

/**
 * Invoker.
 *
 * Объект Invoker. Хранит команду и в определенный момент отдает запрос
 * на ее выполнение, вызывая метод execute().
 */
public class SimpleRemoteControl {
    // Всего одна ячейка для хранения команды (и одно управляемое устройство).
    Command slot;

    public SimpleRemoteControl() {}

    /**
     * Метод для назначения команды. Может вызываться повторно, если клиент
     * кода захочет изменить поведение кнопки.
     */
    public void setCommand(Command command) {
        slot = command;
    }

    /**
     * Метод, вызываемый при нажатии кнопки. Мы просто берем объект команды,
     * связанный с текущей ячейкой, и вызываем его метод execute().
     */
    public void buttonWasPressed() {
        slot.execute();
    }
}
