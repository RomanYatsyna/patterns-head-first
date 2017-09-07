package command.macrocommands;

/**
 * Фиктивная команда, не делает ничего. Сделана для того, чтобы слоты
 * изначально заполнялись фиктивными командами. Тогда нет необходимости
 * выполнять проверки на наличие команды.
 */
public class NoCommand implements Command {
    @Override
    public void execute() { }

    @Override
    public void undo() { }
}
