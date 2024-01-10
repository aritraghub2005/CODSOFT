import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.nio.file.Files;
import java.nio.file.Paths;


public class task5 {
    // global variables
    private static List<List<String>> qnapair = new ArrayList<>();
    private static Random randomGenerator = new Random();
    static String[][] questions = { { "001 ","What is the capital of the India?" },
            { "002", "What is the capital of Canada?" }, { "003", "What is the capital of Australia?" },
            { "004", "What is the capital of New Zealand?" } };
    static String[][] answers = { { "001", "New Delhi" }, { "002", "Ottawa" }, { "003", "Canberra" }, { "004", "Wellington" } };
    // making nested array of questions and answers
    // static String[][] questions = { { "001", "What is the capital of the India?"
    // },
    // { "002", "What is the capital of Canada?" }, { "003", "What is the capital of
    // A
    // ustralia?" }, { "004", "What is the capital of New Zealand?" } };
    // static String[][] answers = { { "001", "New Delhi" }, { "002", "Ottawa"
    // }, { "003", "Canberra" }, { "004", "Wellington" } };


    // declaring the file path to the json file
    static String file = "qus.json";
    // static String afile = "filepath";

    public static void TASK4() {
        JFrame frame = new JFrame("Hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Container container = frame.getContentPane();
        JPanel panel = new JPanel();
        container.add(panel);

        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Text in center");
        panel.add(label);

        JButton button = new JButton("Button");
        panel.add(button);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        addqna();
        do {
            List<String> cqna = task5.randqna();
            System.out.println(cqna);
            if(cqna == null) {
                System.out.println("No Questions");
                break;
            }

        } while (true );
        // jspooonn
        loadJson();
        
    }

    public static void addqna() {
        // adding the questions and answers to the list
        System.out.println("Adding questions and answers");
        for (int i = 0; i < 4; i++) {
            List<String> pair = new ArrayList<>();
            pair.add(questions[i][1]);
            pair.add(answers[i][1]);
            qnapair.add(pair);
            // qnapair.add(questions[i][1]);
            // qnapair.add(answers[i][1]);
        }
        // qnapair.add(questions[0][1]);
        // qnapair.add(answers[0][1]);
       System.out.println(qnapair);
       
    }

    // making a quiz funtion returning a json file
    public static List<String> randqna() {
      
        

        // saving the questions and answers in random order to one new array
        if (qnapair.isEmpty()) {

            // No more questions available
            System.out.println("No more questions available");  
            return null;
        }

        // Get a random index and remove the question-answer pair from the list
        int randomIndex = randomGenerator.nextInt(qnapair.size());
        return qnapair.remove(randomIndex);

    }

    //function to load the json file
     public static void loadJson() {
        try {
        String json = new String(Files.readAllBytes(Paths.get(file)));
        //printing the json file
        System.out.println(json);

        } catch (IOException e) {
        e.printStackTrace();
            System.out.println("File not found");
        }

}}
