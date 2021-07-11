import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class WelcomeG extends JFrame implements ActionListener {
 JFrame welcome, service;
 JLabel l1, l2;
 JButton b;
 Checkbox c1, c2, c3;
 public WelcomeG() {
 //Fonts
 Font font1 = new Font("Algerian", Font.BOLD, 20);
 Font font2 = new Font("Algerian", Font.BOLD, 40);
 //welcome page
 welcome = new JFrame("Welcome");
 welcome.setContentPane(new JLabel(new ImageIcon("Nail1.png")));
 welcome.getContentPane().setBounds(700, 60, 500, 400);
 b = new JButton("Know more");
 b.setBounds(480, 200, 100, 30);
 welcome.add(b);
 b.addActionListener(this);
 l1 = new JLabel("WELCOME to");
 l1.setBounds(450, 0, 150, 50);
 l1.setFont(font1);
 welcome.add(l1);
 l2 = new JLabel("GVOZI");
 l2.setBounds(450, 50, 150, 50);
 l2.setFont(font2);
 welcome.add(l2);
 welcome.setSize(645, 325);
 welcome.setLayout(null);
 welcome.setVisible(true);
 welcome.setLocationRelativeTo(null);
 }
 public static void main(String[] args) throws Exception {
 new WelcomeG();
// new Service();
 }
 @Override
 public void actionPerformed(ActionEvent e) {
 welcome.setVisible(false);
 new Service();
 }
} 