package observer.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Простое приложение Swing, создает панель и размещает на ней кнопку
 */
public class SwingObserversExample extends JFrame{
    public static void main(String[] args) {
        SwingConsole.run(new SwingObserversExample(), 400, 400);
    }

    private SwingObserversExample() {
        JButton button = new JButton("Should I do it?");

        // Назначаем объекты слушателями (наблюдателями) событий кнопки
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        add(BorderLayout.CENTER, button);
    }

    class AngelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Don't do it, you might regret it!");
        }
    }

    class DevilListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Come on, do it!");
        }
    }
}
