import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;

class MyPanel extends JPanel {

	private static int pressed = 0;
 	public static void main() {
    		 JFrame frame = new JFrame ("Simple Frame");
    		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		 frame.setSize(300, 120);
        
        JPanel panel1 = new JPanel(); 
   		JPanel panel2 = new JPanel();
        
   		JLabel l = new JLabel ("Label1 ");
   		JTextField tf = new JTextField("TextField1");
   		panel1.add(l);
   		panel1.add(tf);
   		panel1.setLayout(new FlowLayout());
   		
   		JButton b1 = new JButton("Button 1");
   		JButton b2 = new JButton("Button 2");
   		JButton b3 = new JButton("Button 3");
   		
   	 b1.addActionListener(new ActionListener() {
    
         public void actionPerformed(ActionEvent e) {
             MyPanel.pressed++;
             l.setText(""+pressed);
         }
     });
   	 
     b2.addActionListener(new ActionListener() {
        
         public void actionPerformed(ActionEvent e) {
             l.setText(tf.getText());
         }
     });
     
   
   		panel2.add(b1);
   		panel2.add(b2);
   		panel2.add(b3);
   		
   		JPanel p = new JPanel();
   		p.add(panel1);
   		p.add(panel2);
   		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        
   		frame.setContentPane(p);
   		frame.setVisible(true);  
   		
   	  b3.addActionListener(new ActionListener() {
   	     
          public void actionPerformed(ActionEvent e) {
        	  
              Random rand = new Random();
              Color randomColor = new Color(rand.nextInt(0xFFFFFF));
              panel1.setBackground(randomColor);
              panel2.setBackground(randomColor);
              p.setBackground(randomColor);
          }
      });
   	 }
}
