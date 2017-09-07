package command.remoteWL;

/**
 * Invoker.
 *
 * Реализация RemoteControl. В этой версии пульт будет поддерживать все семь команд.
 * "вкл/выкл", которые будут храниться в соответствующих массивах.
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    /**
     * Конструктор создает экземпляры команд и инициализирует массивы onCommands и
     * offCommands.
     */
    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        for (int i = 0; i < 7; i++) {
            onCommands[i] = () -> {};
            offCommands[i] = () -> {};
        }
    }

    /**
     * Метод получает слот и команды включения/выключения для этого слота.
     * Команды сохраняются в массивах для последующиего успользования.
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    /* При нажатии кнопки "Вкл"/"Выкл" пульт вызывает соответствующий метод
    onButtonWasPushed() или offButtonWasPushed().

     */
    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }
}