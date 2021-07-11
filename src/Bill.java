import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.*; 
public class Bill extends JFrame implements ActionListener { 
 JFrame bill; 
 JLabel l1, l2, l3, l4, l5, l6; 
 JButton b1, b2; 
 Bill(String name, String number, String price) { 
 //Fonts
 Font heading1 = new Font("Algerian", Font.BOLD, 22); 
 Font text = new Font("Algerian", Font.PLAIN, 20);  bill = new JFrame("Gvozi Service");
 bill.setContentPane(new JLabel(new ImageIcon("Nail3.jpg"))); 
 bill.getContentPane().setBounds(0, 0, 500, 500); 
 l1 = new JLabel("Name:");
 l1.setBounds(60, 30, 100, 22); 
 l1.setFont(heading1);
 bill.add(l1);
 l2 = new JLabel(name);
 l2.setBounds(200, 30, 300, 22); 
 l2.setFont(heading1);
 bill.add(l2);
 l3 = new JLabel("Mob No:");
 l3.setBounds(60, 80, 100, 22); 
 l3.setFont(heading1);
 bill.add(l3);
 l4 = new JLabel(number);
 l4.setBounds(200, 80, 300, 22); 
 l4.setFont(heading1);
 bill.add(l4);
 l5 = new JLabel("Price:");
 l5.setBounds(60, 130, 100, 22); 
 l5.setFont(heading1);
 bill.add(l5);
 l6 = new JLabel(price);
 l6.setBounds(200, 130, 300, 22); 
 l6.setFont(heading1);
 bill.add(l6);
 b1 = new JButton("Go Back");
 b1.setBounds(150, 280, 200, 22); 
 b1.setFont(text);
 b1.addActionListener(this);
 bill.add(b1);
 b2 = new JButton("Print");
 b2.setBounds(200, 250, 100, 22); 
 b2.setFont(text);
 b2.addActionListener(this);
 b2.setActionCommand("print");
 bill.add(b2);
 bill.setSize(500, 500); 
 bill.setLayout(null);
 bill.setLocationRelativeTo(null);
 bill.setVisible(true);
 } 
 @Override
 public void actionPerformed(ActionEvent e) {  bill.setVisible(false);
 String action = e.getActionCommand(); 
 if (action.equals("print")) { 
 JOptionPane.showMessageDialog(bill, "Your bill has been generated \n  Thankyou");
 } 
 } 
}