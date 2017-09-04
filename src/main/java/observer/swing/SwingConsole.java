package observer.swing;

import javax.swing.*;

/**
 * Шаблон для создания JFrame
 */
public class SwingConsole {
    public static void
    run(final JFrame f, final int width, final int height) {
        SwingUtilities.invokeLater(() -> {
            f.setTitle(f.getClass().getSimpleName());
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setSize(width, height);
            f.setVisible(true);
        });
    }
}