// Tic-Tac-Toe Main

// Written by: Nathan Aronson
// Date: June 16, 2021
// Description: This is the main class for Tic-Tac-Toe that uses graphics.
//				Start code written by Mr. Swope

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToeMain extends JFrame{
			
		public static void main(String[] args){	
			TicTacToeMain window = new TicTacToeMain();
	        JPanel p = new JPanel();
	        p.add(new TicTacToePanel());
	        window.setTitle("Tic-Tac-Toe");
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        window.setContentPane(p);
	        
	        window.pack();
	        window.setLocationRelativeTo(null);
	        window.setVisible(true);
		}

}