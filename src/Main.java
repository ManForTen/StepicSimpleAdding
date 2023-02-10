import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    static JFrame frame = new JFrame();//создаем форму
    static int width = 500, height = 500;
    static JLayeredPane panel = new JLayeredPane();

    static public void add(MouseEvent e){ // Метод добавления объекта по клику
        if (e.getButton()==1){ // Если кнопка левая
            JLabel label = new JLabel("X:"+e.getX()+" Y:"+e.getY());
            label.setBounds(e.getX(),e.getY(),100,20);
            panel.add(label);
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("Добавление мышкой");
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
                panel.setFocusable(true); // Делаем у панели возможность принимать фокус, иначе она не сможет отловить события клавиатуры
                frame.add(panel); // Добавляем панель на форму
                panel.addMouseListener(new MouseAdapter() { // Добавляем слушателя мыши на панель
                    public void mouseClicked(MouseEvent e) {
                        add(e);
                    }
                });
                frame.setVisible(true);
            }
        });
    }
}