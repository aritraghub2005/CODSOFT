import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;

public class Task extends JFrame {

  private JFrame f = new JFrame("My Quizo");
  private JPanel container = new JPanel(new CardLayout());

  // Create panels
  private JPanel panel1 = new JPanel();
  private JPanel panel2 = new JPanel();
  private JPanel panel3 = new JPanel();
  private JPanel panel4 = new JPanel();
  private JPanel panel5 = new JPanel();
  private JPanel panel6 = new JPanel();

  // Creat buttons
  private JButton button1 = new JButton("Log in");
  private JButton button2 = new JButton("Start Quiz");

  // Create TextFields
  private JTextField textField1 = new JTextField(20);

  // Create Timer
  private JLabel timerLabel = new JLabel("Time Left: ");
  private int countdown = 10;
  private Timer countdownTimer;

  // text
  private JLabel label1 = new JLabel("enter you text");

  public Task() {

    setTitle("My Quizo");
    panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 430, 430));
    panel1.add(button1);
    button2.setBounds(190, 420, 95, 30);

    setSize(500, 500);

    // panel background colour
    panel1.setBackground(Color.WHITE);
    panel2.setBackground(Color.WHITE);
    panel3.setBackground(Color.WHITE);
    panel4.setBackground(Color.BLACK);
    panel5.setBackground(Color.WHITE);
    panel6.setBackground(Color.WHITE);

    // panel added to container
    container.add(panel1, "Panel 1");
    container.add(panel2, "Panel 2");
    container.add(panel3, "Panel 3");
    container.add(panel4, "Panel 4");
    container.add(panel5, "Panel 5");
    container.add(panel6, "Panel 6");

    // Buttons added to panel
    panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 430, 430));
    panel1.add(button1);
    panel2.add(new JLabel("Username "));
    panel2.add(textField1);
    panel2.add(button2);

    // Functions added to buttons
    button1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) container.getLayout();
        cardLayout.show(container, "Panel 2");
      }
    });

    button2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        startCountdownTimer();
        CardLayout cardLayout = (CardLayout) container.getLayout();
        cardLayout.show(container, "Panel 3");
      }
    });

    countdownTimer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        countdown--;
        if (countdown >= 0) {
          timerLabel.setText("Time Left: " + countdown);
        } else {
          countdownTimer.stop();
          CardLayout cardLayout = (CardLayout) container.getLayout();
          cardLayout.show(container, "Panel 4");

        }
      }
    });

    // Add timer label to panel3
    FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);
    panel3.setLayout(flowLayout);
    panel3.add(timerLabel);

    // formating text inside the panel
    panel3.setLayout(new BorderLayout());
    label1.setText("Your Text Here");
    label1.setHorizontalAlignment(SwingConstants.CENTER);
    panel3.add(label1, BorderLayout.NORTH);
    Font cambriaMath = new Font("Cambria Math", Font.PLAIN, 20);
    label1.setForeground(Color.black);
    label1.setFont(cambriaMath);

    JPanel radioPanel = new JPanel();
    radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
    JRadioButton radio1 = new JRadioButton("option 1");
    JRadioButton radio2 = new JRadioButton("option 2");
    JRadioButton radio3 = new JRadioButton("option 3");
    JRadioButton radio4 = new JRadioButton("option 4");

    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(radio1);
    buttonGroup.add(radio2);
    buttonGroup.add(radio3);
    buttonGroup.add(radio4);

    radioPanel.add(radio1);
    radioPanel.add(radio2);
    radioPanel.add(radio3);
    radioPanel.add(radio4);

    panel3.add(radioPanel, BorderLayout.CENTER);

    add(container);
    setLocationRelativeTo(null);
    setVisible(true);

  }

  private void startCountdownTimer() {
    countdown = 10; // Reset countdown to 10 seconds
    countdownTimer.start();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new Task());
  }
}