import javax.swing.*;
import java.awt.*;

public class TASK1 extends JFrame {

    public TASK1() {
        setTitle("Transparent Panels Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel greenPanel = new JPanel();
        greenPanel.setPreferredSize(new Dimension(200, 200));
        greenPanel.setBackground(new Color(144, 238, 144, 150)); // Set the background color with transparency

        JPanel blackPanel = new JPanel();
        blackPanel.setPreferredSize(new Dimension(200, 200));
        blackPanel.setBackground(new Color(0, 0, 0, 150)); // Set the background color with transparency

        JLabel label = new JLabel("Hello, this is some text!");
        label.setForeground(Color.WHITE); // Set the text color

        add(greenPanel);
        add(blackPanel);
        add(label);

        setSize(450, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TASK1::new);
    }
}
