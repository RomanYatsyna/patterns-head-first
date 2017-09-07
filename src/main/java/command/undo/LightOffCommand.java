package command.undo;

/**
 * Чтобы отменить его последствия, метод undo() вызывает противоположный
 * метод.
 */
public class LightOffCommand implements Command {
    Light light;
    int level;
    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        level = light.getLevel();
        light.off();
    }

    @Override
    public void undo() {
        light.dim(level);
    }
}