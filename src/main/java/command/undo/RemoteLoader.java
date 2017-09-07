package command.undo;

public class RemoteLoader {

    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        // Создане объекта Light и новых команд с поддержкой отмены.
        Light livingRoomLight = new Light("Living Room");
        LightOnCommand livingRoomLightOn =
                new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff =
                new LightOffCommand(livingRoomLight);

        // Команды размещаются в слоте 0.
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);

        // Включение, выключение и отмена.
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();

        // Выключение, включение и снова отмена.
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();

        // Создаем объект CeilingFan для Living Room
        CeilingFan ceilingFan = new CeilingFan("Living Room");

        // Создаем экземпляры трех команд: высокой, средней скорости и выключения
        CeilingFanMediumCommand ceilingFanMedium =
                new CeilingFanMediumCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHigh =
                new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff =
                new CeilingFanOffCommand(ceilingFan);

        // Команды включения средней и высокой скорости помещаются в слоты 0 и 1.
        remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);

        // Сначала включаем среднюю скорость
        remoteControl.onButtonWasPushed(0);
        // Потом выключаем вентилятор.
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        // Отмена. Снова должна включиться средняя скорость.
        remoteControl.undoButtonWasPushed();

        // На этот раз выбираем высокую скорость.
        remoteControl.onButtonWasPushed(1);
        System.out.println(remoteControl);
        // Снова отмена. Должна включиться средняя скорость.
        remoteControl.undoButtonWasPushed();
    }
}