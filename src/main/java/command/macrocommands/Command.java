package command.macrocommands;

/**
 * Реализация интерфейса Command.
 * Команды, поддерживающие механизм отмены должны содержать метод undo().
 */
public interface Command {
    public void execute();
    public void undo();
}
