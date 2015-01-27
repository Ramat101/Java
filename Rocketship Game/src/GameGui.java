import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class GameGui{
	JFrame frame;
	JButton button;
	
	public class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			Image space = new ImageIcon("space image.jpg").getImage();
			Image space2 = new ImageIcon("space image.jpg").getImage();
			Image explosion = new ImageIcon("space explosion 2.jpg").getImage();
			g.drawImage(space, 0, 4, 300, 200, this);
			g.drawImage(explosion, 300, 4, 300, 200, this);
			g.drawImage(space2, 600, 4, 300, 200, this);			
		}
	}
	public class MyDrawPanel1 extends JPanel{
		public void paintComponent(Graphics g){
			Image space1 = new ImageIcon("space image.jpg").getImage();
			g.drawImage(space1, 0, 0,300,300, this);			
		}
	}
	public class MyDrawPanel2 extends JPanel{
		public void paintComponent(Graphics g){
			Image space = new ImageIcon("space explosion 2.jpg").getImage();
			g.drawImage(space, 0, 0,300,300, this);			
		}
	}
	
	public void start(){
		frame = new JFrame("Rocketship Game");
		//MyDrawPanel panel = new MyDrawPanel();
		MyDrawPanel1 panel1 = new MyDrawPanel1();
		MyDrawPanel2 panel2 = new MyDrawPanel2();
		JPanel bottomHalf = new JPanel();
		JTextField text = new JTextField(20);
		button = new JButton("Attack");	
		button.addActionListener(new AttackListener()); //the agrgument of an ActionListener is an object which implements the ActionListener interface	
		bottomHalf.add(BorderLayout.EAST, button);
		bottomHalf.add(BorderLayout.WEST, text);
		//frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(panel1);
		frame.getContentPane().add(panel2);
		
		frame.getContentPane().add(bottomHalf);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,700);
		frame.setVisible(true);
	}
	
	public class AttackListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//read coordinates in from text area- getUserInput(String prompt)
			//evaluate the result- checkUserInput(attack, ships);
			//print result to JFrame
			button.setText("CLICKED");
		}//actionPerformed
	}//AttackListener
}//GameGui


//to put a JPEG on a widget graphics.drawImage(myPic,10,10,this);
