package command.remote;

public class StereoOnWithCDCommand implements Command {
    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /**
     * Для выполнения этой команды необъодимо выполнить 3 операции со стереосистемой:
     * включить ее, установить режим возпроизведения CD и установить громкость на
     * уровне 11.
     */
    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}
