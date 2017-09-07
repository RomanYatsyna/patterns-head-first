package command.remote;

/**
 * Invoker.
 *
 * Реализация RemoteControl. В этой версии пульт будет поддерживать все семь команд.
 * "вкл/выкл", которые будут храниться в соответствующих массивах.
 *
 * Класс RemoteControl управляет набором объектов команд (по одному на кнопку). При
 * нажатии кнопки вызывается соответствующий метод buttonWasPushed(), который активи-
 * зирует метод execute() объекта команды. Класс пульта больше ничего не значе о тех
 * классах, к которым он обращается, так как он отделен от них объектом команды.
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

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
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