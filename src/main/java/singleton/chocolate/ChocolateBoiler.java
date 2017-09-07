package singleton.chocolate;

/**
 * Пример с нагревателем для шоколада. Автор приложил усилия, чтобы избежать
 * слива холодного шоколада, переполнения или нагревания пустой емкости.
 */
public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;
    private static ChocolateBoiler uniqueInstance;

    // Код выполняется только при пустом нагревателе.
    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Creating unique instance of Chocolate Boiler");
            uniqueInstance = new ChocolateBoiler();
        }
        System.out.println("Returning instance of Chocolate Boiler");
        return uniqueInstance;
    }

    /* Перед наполненением мы проверяем, что нагреватель пуст, а после наполнения
     устанавливаем флаги empty и boiled.*/
    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            // fill the boiler with a milk/chocolate mixture
        }
    }

    /* Чтобы слить содержимое, мы проверяем, что нагреватель не пуст, а смесь доведена
     до кипения. После слива флагу empty снова присваивается true.*/
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // drain the boiled milk and chocolate
            empty = true;
        }
    }

    /* Чтобы вскипятить смесь, мы проверяем, что нагреватель полон, но еще не нагрет.
     После нагревания флагу boiled присваивается true.*/
    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // bring the contents to a boil
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}