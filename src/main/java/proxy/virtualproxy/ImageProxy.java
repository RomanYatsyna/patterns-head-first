package proxy.virtualproxy;

import java.net.*;
import java.awt.*;
import javax.swing.*;

/**
 * Класс ImageProxy реализует интерфейс Icon. В переменной imageIcon хранится
 * НАСТОЯЩИЙ объект Icon, который должен отображаться после загрузки.
 */
class ImageProxy implements Icon {
    volatile ImageIcon imageIcon;
    final URL imageURL;
    Thread retrievalThread;
    boolean retrieving = false;

    /**
     * Конструктору передается URL изображения - того, которое должно отображаться
     * после загрузки.
     */
    public ImageProxy(URL url) { imageURL = url; }

    // До завершения загрузки возвращаются значения длины/ширины по умолчанию.
    @Override
    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }

    @Override
    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
            return 600;
        }
    }

    synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    /**
     * Изображение отрисовывается на экране (вызов делегируется imageIcon). Но если
     * объект ImageIcon еще не создан, мы создаем его.
     *
     * Метод вызывается тогда, когда требуется перерисовать изображение на экране.
     */
    @Override
    public void paintIcon(final Component c, Graphics  g, int x, int y) {
        // Если объект уже существует, то требование о перерисовке передается ему.
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
            // В противном случае выводится сообщение о загрузке.
        } else {
            g.drawString("Loading CD cover, please wait...", x+300, y+190);
            // Если загрузка изображения еще не началась.
            if (!retrieving) {
                // ... можно начать загрузку.
                retrieving = true;

                /* Чтобы загрузка не парализовала пользовательский интерфейс, она будет
                 выполняться в отдельном потоке. Здесь загружается НАСТОЯЩЕЕ изображение.
                 Следует учесть, что загрузка осуществляется синхронно: конструктор
                 ImageIcon не возвращает управление до завершения загрузки. Соответственно,
                 операции обновления экрана и вывода сообщения приходится осуществлять
                 асинхронно.*/
                retrievalThread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            // В отдельном потоке создается экземпляр объекта Icon.
                            setImageIcon(new ImageIcon(imageURL, "CD Cover"));
                            c.repaint();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                retrievalThread.start();
            }
        }
    }
}