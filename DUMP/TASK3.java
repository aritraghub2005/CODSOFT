import javax.swing.*;
import java.awt.event.*;

public class TASK3 {

  public static void main(String[] args) {
    JFrame f = new JFrame("ATM");
    JButton c = new JButton("Balance");
    c.setBounds(10, 0, 95, 30);
    f.add(c);
    f.setSize(400, 400);
    f.setLayout(null);
    f.setVisible(true);
    JButton b = new JButton("Withdraw");
    b.setBounds(10, 100, 95, 30);
    f.add(b);
    
    f.setSize(400, 400);
    f.setLayout(null);
    f.setVisible(true);
    JButton a = new JButton("Deposit");
    a.setBounds(10, 50, 95, 30);
    f.add(a);
    f.setSize(400, 400);
    f.setLayout(null);
    f.setVisible(true);

    JButton d = new JButton("Exit");
    d.setBounds(10, 150, 95, 30);
    f.add(d);
    f.setSize(400, 400);
    f.setLayout(null);
    f.setVisible(true);

    d.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }
}