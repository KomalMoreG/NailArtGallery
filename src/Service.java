import java.awt.*;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.*; 
import java.sql.*;

import static java.lang.Integer.parseInt; 
public class Service extends JFrame implements ActionListener { 
 JFrame service; 
 JLabel l1, l2, l3, l4, l5; 
 JCheckBox c1, c2, c3; 
 JTextField t1, t2, t3, t4, t5, t6; 
 JButton b1, b2; 
 
 Connection con;
 PreparedStatement pst;
 
 Service() { 
	 Connect();
 //Fonts
 Font heading1 = new Font("Algerian", Font.BOLD, 22); 
 Font text = new Font("Algerian", Font.PLAIN,15); 
 //service page
 service = new JFrame("Gvozi Service");
 service.setContentPane(new JLabel(new ImageIcon("Nail3.jpg"))); 
 service.getContentPane().setBounds(20, 20, 800, 500); 
 //services
 l1 = new JLabel("Services");
 l1.setBounds(60, 30, 100, 22); 
 l1.setFont(heading1);
 service.add(l1);
 c1 = new JCheckBox("Nail Extension");
 c1.setBounds(60, 80, 200, 20); 
 c1.setFont(text);
 c1.addActionListener(this);
 service.add(c1);
 c2 = new JCheckBox("Nail Art");
 c2.setBounds(60, 130, 200, 20); 
 c2.setFont(text);
 c2.addActionListener(this); service.add(c2);
 c3 = new JCheckBox("Permanent Paint");
 c3.setBounds(60, 180, 200, 20); 
 c3.setFont(text);
 c3.addActionListener(this);
 service.add(c3);
 //Price
 l2 = new JLabel("Price");
 l2.setBounds(500, 30, 100, 22); 
 l2.setFont(heading1);
 service.add(l2);
 t1 = new JTextField(); 
 t1.setBounds(500, 80, 100, 22); 
 t1.setFont(text);
 t1.setEditable(false);
 t1.addActionListener(this);
 service.add(t1);
 t2 = new JTextField(); 
 t2.setBounds(500, 130, 100, 22); 
 t2.setFont(text);
 t2.setEditable(false);
 service.add(t2);
 t3 = new JTextField(); 
 t3.setBounds(500, 180, 100, 22); 
 t3.setFont(text);
 t3.setEditable(false);
 service.add(t3);
 //Total price
 b1 = new JButton("Total Price :");
 b1.setBounds(350, 230, 150, 22); 
 b1.setFont(text);
 b1.addActionListener(this);
 b1.setActionCommand("total");
 service.add(b1);
 t4 = new JTextField("0.0");
 t4.setBounds(500, 230, 100, 22); 
 t4.setFont(text);
 t4.setEditable(false);
 service.add(t4);
 JSeparator hr = new JSeparator(); 
 hr.setBounds(0, 280, 800, 1); 
 service.add(hr);
 //Customer details
 l5 = new JLabel("Customer Details");
 l5.setBounds(60, 300, 200, 22);  l5.setFont(text);
 service.add(l5);
 l3 = new JLabel("Name");
 l3.setBounds(60, 340, 150, 22); 
 l3.setFont(text);
 service.add(l3);
 t5 = new JTextField(); 
 t5.setBounds(60, 380, 150, 22); 
 t5.setFont(text);
 service.add(t5);
 l4 = new JLabel("Phonenumber");
 l4.setBounds(300, 340, 200, 22); 
 l4.setFont(text);
 service.add(l4);
 t6 = new JTextField(); 
 t6.setBounds(300, 380, 150, 22); 
 t6.setFont(text);
 service.add(t6);
 b2 = new JButton("Generate Bill");
 b2.setBounds(500, 360, 200, 22); 
 b2.setFont(text);
 b2.addActionListener(this);
 b2.setActionCommand("bill");
 service.add(b2);
 service.setSize(800, 500); 
 service.setLayout(null);
 
 service.setVisible(true);
 service.setLocationRelativeTo(null);
 } 
 @Override
 public void actionPerformed(ActionEvent e) { 
 if (c3.isSelected()) { 
 c2.setSelected(true);
 t2.setEditable(true);
 t3.setEditable(true);
 } else { 
 t3.setEditable(false);
 } 
 t2.setEditable(c2.isSelected()); 
 t1.setEditable(c1.isSelected()); 
 String action = e.getActionCommand(); 
 if (action.equals("total")) {  totalCalculate(); 
 } 
 if (action.equals("bill")) { 
	 String name = t5.getText();
	 String number = t6.getText();
	 String price = t4.getText();
	 
	 try {
		 pst= con.prepareStatement("Insert into customer(cname,phoneno,tottalprice)values(?,?,?)");
		 pst.setString(1, name);
		 pst.setString(2, number);
		 pst.setString(3, price);
		 
		 int k =pst.executeUpdate();
		 if(k==1) {
			 new Bill(t5.getText(),t6.getText(),t4.getText()); 
		 }
		 else {
			 JOptionPane.showMessageDialog(this, "Failed");
		} 

	 }catch (SQLException throwables) {
			throwables.printStackTrace();
			
		}

 
 
 } 
 
 } 
 public void totalCalculate() { 
 int total = 0; 
 int val1 = t1.getText().equals("") ? 0 : parseInt(t1.getText()); 
 int val2 = t2.getText().equals("") ? 0 : parseInt(t2.getText()); 
 int val3 = t3.getText().equals("") ? 0 : parseInt(t3.getText()); 
 if (t1.isEditable()) { 
 total = total + val1; 
 } 
 if (t2.isEditable()) { 
 total = total + val2; 
 } 
 if (t3.isEditable()) { 
 total = total + val3; 
 } 
 t4.setText(String.valueOf(total)); 
 } 
 
 public void Connect() {
     try {
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nails","root","2612");
     } catch (ClassNotFoundException e) {
         e.printStackTrace();
     } catch (SQLException throwables) {
         throwables.printStackTrace();
     }
 }
 
 
}