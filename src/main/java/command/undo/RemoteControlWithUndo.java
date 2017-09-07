package command.undo;

/**
 * Invoker.
 */
public class RemoteControlWithUndo {
    Command[] onCommands;
    Command[] offCommands;
    // Переменная для хранения последней выполненной команды.
    Command undoCommand;

    public RemoteControlWithUndo() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for(int i=0;i<7;i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        /* В переменную undoCommand изначально также заносится объект noCommand,
         чтобы при нажатии кнопки отмены раньше любых других кнопок ничего
         не происходило.*/
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }


    /**
     * При нажатии кнопки мы сначала читаем команду и выполняем ее, а затем
     * сохраняем ссылку на нее в переменной undoCommand.
     */
    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    /**
     * При нажатии кнопки мы сначала читаем команду и выполняем ее, а затем
     * сохраняем ссылку на нее в переменной undoCommand.
     */
    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    /**
     * При нажатии кнопки отмены мы вызываем метод undo() команды, хранящейся в
     * переменной undoCommand(). Вызов отменяет операцию последней выполненной
     * команды.
     */
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + "    " + offCommands[i].getClass().getName() + "\n");
        }
        stringBuff.append("[undo] " + undoCommand.getClass().getName() + "\n");
        return stringBuff.toString();
    }
}