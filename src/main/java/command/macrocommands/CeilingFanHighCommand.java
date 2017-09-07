package command.macrocommands;

public class CeilingFanHighCommand implements Command {
    CeilingFan ceilingFan;
    // Добавляем локальную переменную состояни для хранения предыдущей скорости.
    int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /**
     * В методе execute() перед изменением скорости ее предыдущее
     * значение сохраняется для возможной отмены.
     */
    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    /**
     * В методе undo() вентилятор возвращается к предыдущей скорости.
     */
    @Override
    public void undo() {
        switch (prevSpeed) {
            case CeilingFan.HIGH: 	ceilingFan.high(); break;
            case CeilingFan.MEDIUM: ceilingFan.medium(); break;
            case CeilingFan.LOW: 	ceilingFan.low(); break;
            default: 				ceilingFan.off(); break;
        }
    }
}