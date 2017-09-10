package templatemethod.frame;

import java.awt.*;
import javax.swing.*;

/**
 * Класс расширяет JFrame, который содержит метод update(), управляющий
 * перерисовкой экрана. Чтобы подключиться к этому алгоритму, переопределяется
 * метод paint().
 * В данном примере показывается, что метод paint() является перехватчиком.
 */
public class MyFrame extends JFrame {
    private static final long serialVersionUID = 2L;

    public MyFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300,300);
        this.setVisible(true);
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        String msg = "I rule!!";
        graphics.drawString(msg, 100, 100);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("Head First Design Patterns");
    }
}