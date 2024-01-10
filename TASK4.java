import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

public class TASK4 extends JFrame {
  private Container container1;
  private Container container2;
  private Container container3;
  private Container container4;
  private int score;
  private static List<List<String>> qnapair = new ArrayList<List<String>>();
  public List<String> newq = new ArrayList<String>();

  private static Random randomGenerator = new Random();
  private JLabel timerLabel;
  private int time = 10;
  private Timer timer;
  // declaring the file path to the json file
  static String file = "qus.json";

  public TASK4() {
    setTitle("My Quizo");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    container1 = new JPanel();
    container1.setLayout(new GridLayout(2, 1));
    container2 = new JPanel();
    container2.setLayout(new GridLayout(2, 1));
    container3 = new JPanel();
    container3.setLayout(new GridLayout(2, 1));
    container4 = new JPanel();
    container4.setLayout(new GridLayout(1,1));

    JPanel panel1 = new JPanel(new GridBagLayout());
    JPanel panel2 = new JPanel(new GridBagLayout());
    JPanel panel3 = new JPanel(new GridBagLayout());
    JPanel panel4 = new JPanel(new GridBagLayout());
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel(new GridBagLayout());
    JPanel panel7 = new JPanel(new GridBagLayout());

    panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
   

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.gridx = GridBagConstraints.RELATIVE;
    gbc.gridy = GridBagConstraints.RELATIVE;

    // Anchor the component to the bottom-right corner
    gbc.anchor = GridBagConstraints.SOUTHEAST;

    timerLabel = new JLabel("5");
    timerLabel.setFont(new Font("Arial", Font.BOLD, 50));
    panel6.add(timerLabel);

    // panel background colour
    panel1.setBackground(new Color(210, 143, 51));
    panel2.setBackground(new Color(212, 185, 94)); 
    panel3.setBackground(new Color(210, 143, 51));
    panel4.setBackground(new Color(212, 185, 94));
    panel5.setBackground(new Color(247, 218, 121));
    panel6.setBackground(new Color(210, 143, 51));
    panel7.setBackground(new Color(245, 161, 47));

    // Create buttons
    JButton button1 = new JButton("Log in");
    JButton button2 = new JButton("Start Test");
    JButton button3 = new JButton("Next");

    // adding text fields
    JLabel text1 = new JLabel("Welcome to Quizo");
    JLabel scored = new JLabel("Score : ");
    text1.setForeground(Color.WHITE);
    text1.setFont(new Font("Elephant", Font.BOLD, 50));
    scored.setForeground(new Color(0, 85, 255));
    scored.setFont(new Font("Colonna MT",  Font.ROMAN_BASELINE, 60));
    JTextField textfd = new JTextField(30);
    JLabel label = new JLabel("Enter Your Name"); // Added label
    label.setFont(new Font("Cambria Math", Font.BOLD, 25));
    label.setForeground(Color.WHITE);
    JLabel name = new JLabel("your name");
    name.setFont(new Font("Colonna MT", Font.ROMAN_BASELINE, 60));
    name.setForeground(Color.WHITE);


    JTextArea radioLabel = new JTextArea("Enter your question");
    radioLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    radioLabel.setAlignmentY(Component.TOP_ALIGNMENT);
    radioLabel.setOpaque(false);
    radioLabel.setFont(new Font("Britannic Bold", Font.ROMAN_BASELINE, 26));
    radioLabel.setForeground(Color.BLACK);
    radioLabel.setWrapStyleWord(true);
    radioLabel.setLineWrap(true);

    radioLabel.setEditable(false);

    // ENTER RADIO BUTTONS IN PANEL5
    JRadioButton radio1 = new JRadioButton("Option 1");
    radio1.setVisible(true);
    JRadioButton radio2 = new JRadioButton("Option 2");
    radio2.setVisible(true);
    JRadioButton radio3 = new JRadioButton("Option 3");
    radio3.setVisible(true);
    JRadioButton radio4 = new JRadioButton("Option 4");
    radio4.setVisible(true);

    radio1.setFont(new Font("Arial", Font.BOLD, 20));
    radio1.setForeground(radioLabel.getForeground());
    radio1.setVerticalAlignment(SwingConstants.TOP);
    radio1.setHorizontalAlignment(SwingConstants.LEFT);
    radio2.setFont(radio1.getFont());
    radio2.setForeground(radioLabel.getForeground());
    radio4.setFont(radio1.getFont());
    radio4.setForeground(radioLabel.getForeground());
    radio3.setFont(radio1.getFont());
    radio3.setForeground(radioLabel.getForeground());
  

    ButtonGroup bg = new ButtonGroup();
    bg.add(radio1);
    bg.add(radio2);
    bg.add(radio3);
    bg.add(radio4);
    radio1.setOpaque(false);
    radio2.setOpaque(false);
    radio3.setOpaque(false);
    radio4.setOpaque(false);
    // Align the Radio buttons vertically

    // adding things to panels
    panel1.add(text1);
    panel2.add(button1);
    panel3.add(label);
    panel3.add(Box.createHorizontalStrut(10));
    panel3.add(textfd);
    panel4.add(button2);

    // adding panels to container
    container1.add(panel1);
    container1.add(panel2);
    container2.add(panel3);
    container2.add(panel4);
    container3.add(panel5);
    container3.add(panel6);
    container4.add(panel7);

    // Add radio buttons to panel5
    panel5.add(radioLabel);
    panel5.add(radio1);
    panel5.add(radio2);
    panel5.add(radio3);
    panel5.add(radio4);

    panel6.add(button3, gbc);
    panel6.add(timerLabel, gbc);
    panel7.add(name);
    panel7.add(scored);


    add(container1);
    setLocationRelativeTo(null);
    button1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        container1.setVisible(false);
        container2.setVisible(true);
        add(container2);
      }
    });
    button2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        loadJquestions();
        newq = randqna(qnapair);
        System.out.println(newq);
        container2.setVisible(false);
        container3.setVisible(true);
        timer.start();
        add(container3);
        radioLabel.setText(newq.get(0));
        radio1.setText(newq.get(1));
        radio2.setText(newq.get(2));
        radio3.setText(newq.get(3));
        radio4.setText(newq.get(4));

      }
    });

    timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        time--;
        timerLabel.setText(String.valueOf(time));

        if (time <= 0) {
          if (qnapair.isEmpty()) {
            container3.setVisible(false);
            container4.setVisible(true);
            name.setText(textfd.getText().length() < 1 ? "Hey! Aritra": "Hey! " + textfd.getText() );
            add(container4);
            scored.setText(" Your Score : " + score);
          } else {
            // clearing the previous question
            if (newq.size() > 0) {
              if (bg.getSelection() != null) {
                System.out.println("it works");

                for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
                  AbstractButton button = buttons.nextElement();
                  if (button.isSelected() && button.getText().equals(newq.get(5))) {
                    ++score;
                    System.out.println("Correct Answer");
                    break;
                  } else {
                    System.out.println("Incorrect Answer");
                  }
                }

                bg.clearSelection();
              }
              System.out.println("Clearing the previous question ");
              List<String> newq = new ArrayList<String>();
            }
            newq = randqna(qnapair);
            System.out.println(newq);
            radioLabel.setText(newq.get(0));
            radio1.setText(newq.get(1));
            radio2.setText(newq.get(2));
            radio3.setText(newq.get(3));
            radio4.setText(newq.get(4));
          }
          timer.stop();
          time = 11;
          timer.start();
        }

      }
    });

    button3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        time = 1;
      }
    });

    setSize(800, 600);
    setLocation(400, 100);

    setVisible(true);

  }

  public static List<String> randqna(List<List<String>> qnapair) {

    // saving the questions and answers in random order to one new array
    if (qnapair.isEmpty()) {

      // No more questions available
      System.out.println("No more questions available");
      return null;
    }

    // Get a random index and remove the question-answer pair from the list
    int randomIndex = randomGenerator.nextInt(qnapair.size());
    System.out.println(qnapair.size());
    System.out.println(randomIndex);
    // System.out.println(qnapair.remove(randomIndex));
    return qnapair.remove(randomIndex);

  }

  public static List<List<String>> loadJquestions() {

    qnapair.add(Arrays.asList(
        "What is the capital of France?",
        "Paris", "London", "Rome", "Berlin",
        "Paris"));
    qnapair.add(Arrays.asList(
        "Which planet is known as the Red Planet?",
        "Earth", "Venus", "Mars", "Jupiter",
        "Mars"));
    qnapair.add(Arrays.asList(
        "Which element has the chemical symbol 'H'?",
        "Helium", "Hydrogen", "Hassium", "Hafnium",
        "Hydrogen"));
        qnapair.add(Arrays.asList(
          "What is the capital of Japan?",
          "Beijing", "Seoul", "Tokyo", "Bangkok",
          "Tokyo"));
      qnapair.add(Arrays.asList(
          "Which gas is essential for photosynthesis?",
          "Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen",
          "Carbon Dioxide"));
      qnapair.add(Arrays.asList(
          "Who wrote 'Romeo and Juliet'?",
          "Charles Dickens", "William Shakespeare", "Jane Austen", "Mark Twain",
          "William Shakespeare"));
      qnapair.add(Arrays.asList(
          "What is the currency of Australia?",
          "Euro", "Dollar", "Pound", "Yen",
          "Dollar"));
      qnapair.add(Arrays.asList(
          "Which ocean is the largest?",
          "Indian Ocean", "Atlantic Ocean", "Arctic Ocean", "Pacific Ocean",
          "Pacific Ocean"));
      qnapair.add(Arrays.asList(
          "What is the main ingredient in guacamole?",
          "Tomato", "Avocado", "Onion", "Cilantro",
          "Avocado"));
      qnapair.add(Arrays.asList(
          "Who is known as the 'Father of Computers'?",
          "Alan Turing", "Charles Babbage", "Ada Lovelace", "Bill Gates",
          "Charles Babbage"));
      qnapair.add(Arrays.asList(
          "What is the speed of light in a vacuum?",
          "299,792 kilometers per second", "150,000 kilometers per second", "100,000 kilometers per second", "200,000 kilometers per second",
          "299,792 kilometers per second"));
      qnapair.add(Arrays.asList(
          "Which famous scientist developed the theory of relativity?",
          "Isaac Newton", "Albert Einstein", "Galileo Galilei", "Stephen Hawking",
          "Albert Einstein"));
      qnapair.add(Arrays.asList(
          "What is the largest desert in the world?",
          "Sahara Desert", "Arabian Desert", "Gobi Desert", "Antarctica",
          "Antarctica"));
      qnapair.add(Arrays.asList(
          "Who painted the Mona Lisa?",
          "Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet",
          "Leonardo da Vinci"));
      qnapair.add(Arrays.asList(
          "Which planet is known as the 'Morning Star'?",
          "Mars", "Venus", "Jupiter", "Saturn",
          "Venus"));
      qnapair.add(Arrays.asList(
          "What is the largest organ in the human body?",
          "Heart", "Liver", "Brain", "Skin",
          "Skin"));
      qnapair.add(Arrays.asList(
          "In which year did World War II end?",
          "1945", "1939", "1950", "1940",
          "1945"));
      qnapair.add(Arrays.asList(
          "What is the chemical symbol for gold?",
          "Au", "Ag", "Cu", "Fe",
          "Au"));
      

    return qnapair;

  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new TASK4());
  }

}
