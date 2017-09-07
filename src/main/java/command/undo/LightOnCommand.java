package command.undo;

/**
 * Чтобы отменить его последствия, метод undo() вызывает противоположный
 * метод.
 */
public class LightOnCommand implements Command {
    Light light;
    int level;
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        level = light.getLevel();
        light.on();
    }

    @Override
    public void undo() {
        light.dim(level);
    }
}