package command.macrocommands;

/**
 * Пример макрокоманды, которая запускает другие команды.
 */
public class MacroCommand implements Command {
    Command[] commands;

    /**
     * Берем массив команд и сохраняем их об объекте MacroCommand
     */
    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    /**
     * При выполнении макрокоманды все эти команды будут последовательно
     * выполнены.
     */
    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }

    /**
     * NOTE:  these commands have to be done backwards to ensure
     * proper undo functionality
     */
    public void undo() {
        for (int i = commands.length -1; i >= 0; i--) {
            commands[i].undo();
        }
    }
}