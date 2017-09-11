package state.gumball;

public class GumballMachine {
    // Каждое состояние представлено целым числом.
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    /* Переменная экземпляра для хранения текущего состояния. Мы присваиваем ей исходное
     значение SOLD_OUT, потому что только что распакованный и включенный автомат пуст.*/
    int state = SOLD_OUT;
    // В переменный count хранится количество шариков в автомате.
    int count = 0;

    /**
     * Конструктор получает исходное количество шариков. Если оно отлично от нуля, то авто-
     * мат переходит в сострояние NO_QUARTER, ожидая, что кто-нибудь бросит монету, в про-
     * тивном случае автомат остается в состоянии SOLD_OUT.
     */
    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    /**
     * Когда в автомат бросают монету, если:
     * в автомате уже есть монета, мы сообщаем об этом покупателю;
     * в противном случае автомат принимает монету и переходит в состояние HAS_QUARTER;
     * если шарики распроданы, автомат возвращает монету;
     * если шарик был куплен, следует подождать завершения операции, прежде чем бросить
     * другую монету.
     */
    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("You can't insert another quarter");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("You inserted a quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't insert a quarter, the machine is sold out");
        } else if (state == SOLD) {
            System.out.println("Please wait, we're already giving you a gumball");
        }
    }

    /**
     * Если покупатель пытается вернуть монету:
     * если монета есть, автомат возвращает ее и переходит в состояние NO_QUARTER;
     * если монеты нет, то вернуть ее невозможно;
     * если шарик куплен, вернуть монету нельзя;
     * если шарики кончились, возврат невозможен - автомат не принимает монеты.
     */
    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("Quarter returned");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("You haven't inserted a quarter");
        } else if (state == SOLD) {
            System.out.println("Sorry, you already turned the crank");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't eject, you haven't inserted a quarter yet");
        }
    }

    /**
     * Пользователь пытается дернуть рычаг:
     * и если состояние HAS_QUARTER - пользователь получает шарик, во всех остальных
     * случаях - отказ.
     */
    public void turnCrank() {
        if (state == SOLD) {
            System.out.println("Turning twice doesn't get you another gumball!");
        } else if (state == NO_QUARTER) {
            System.out.println("You turned but there's no quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You turned, but there are no gumballs");
        } else if (state == HAS_QUARTER) {
            System.out.println("You turned...");
            state = SOLD;
            dispense();
        }
    }

    /**
     * Вызывается для выдачи шарика. И если автомат в состоянии SOLD - выдать покупку.
     * Если шарик был последним, автомат переходит в состояние SOLD_OUT, а если нет -
     * возвращается к состоянию NO_QUARTER.
     */
    private void dispense() {
        if (state == SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            count = count - 1;
            if (count == 0) {
                System.out.println("Oops, out of gumballs!");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            System.out.println("You need to pay first");
        } else if (state == SOLD_OUT) {
            System.out.println("No gumball dispensed");
        } else if (state == HAS_QUARTER) {
            System.out.println("No gumball dispensed");
        }
    }

    public void refill(int numGumBalls) {
        this.count = numGumBalls;
        state = NO_QUARTER;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004\n");
        result.append("Inventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\nMachine is ");
        if (state == SOLD_OUT) {
            result.append("sold out");
        } else if (state == NO_QUARTER) {
            result.append("waiting for quarter");
        } else if (state == HAS_QUARTER) {
            result.append("waiting for turn of crank");
        } else if (state == SOLD) {
            result.append("delivering a gumball");
        }
        result.append("\n");
        return result.toString();
    }
}
