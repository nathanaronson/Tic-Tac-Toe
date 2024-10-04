// Tic-Tac-Toe Panel

// Written by: Nathan Aronson
// Date: June 16, 2021
// Description: This project consists of a 4x4 Tic-Tac-Toe game.
// 				Starter code written by Mr. Swope

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TicTacToePanel extends JPanel implements MouseListener{

	private int[][] board;
	private int turn;
	private boolean xWin, oWin;

	// initializes the game
	public TicTacToePanel(){
		setPreferredSize(new Dimension(400, 400));
		this.setFocusable(true);
		this.addMouseListener(this);
		
		turn = 1;
		board = new int[4][4];
	}

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLUE); 

		ImageIcon xImage;
		ImageIcon oImage;
		
		ClassLoader cldr = this.getClass().getClassLoader();
		String imagePath = "images/x.png";
		URL imageURL = cldr.getResource(imagePath);
		xImage = new ImageIcon(imageURL);

		imagePath = "images/o.png";
		imageURL = cldr.getResource(imagePath);
		oImage = new ImageIcon(imageURL);
		
		// displays the winner
		if(checkWinner()) {
			g2.setFont(new Font("Arial", Font.PLAIN, 30));
			g2.setColor(Color.BLUE);
			
			if(xWin) {
				g2.drawString(("GAME OVER. X wins!"), 50, 200);
			}
			if (oWin) {
				g2.drawString(("GAME OVER. O wins!"), 50, 200);
			}
		}
		
		// prints board and paints X or O depending on which turn it is
		else {
			for (int i = 100; i < 400; i += 100)
				g2.fillRect(i, 0, 2, 400);
		
			for (int i = 100; i < 400; i += 100)
				g2.fillRect(0, i, 400, 2);
			
			for(int row = 0; row < board.length; row++) {
				for(int column = 0; column < board[row].length; column++) {
					if(board[row][column] == 1) {
						xImage.paintIcon(this, g2, column * 100, row * 100);
					}
					else if(board[row][column] == -1) {
						oImage.paintIcon(this, g2, column * 100, row * 100);
					}
				}
			}
		}
	}

	// checks for winner
	public boolean checkWinner(){
		// vertical win
		for(int row = 0; row < board.length; row++) {
			if(board[row][0] + board[row][1] + board[row][2] == 3) {
				xWin = true;
				return true;
			}
			if(board[row][0] + board[row][1] + board[row][2] == -3) {
				oWin = true;
				return true;
			}
			if(board[row][1] + board[row][2] + board[row][3] == 3) {
				xWin = true;
				return true;
			}
			if(board[row][1] + board[row][2] + board[row][3] == -3) {
				oWin = true;
				return true;
			}
		}

		// horizontal win
		for(int column = 0; column < board.length; column++) {
			if(board[0][column] + board[1][column] + board[2][column] == 3) {
				xWin = true;
				return true;
			}
			if(board[0][column] + board[1][column] + board[2][column] == -3) {
				oWin = true;
				return true;
			}
			if(board[1][column] + board[2][column] + board[3][column] == 3) {
				xWin = true;
				return true;
			}
			if(board[1][column] + board[2][column] + board[3][column] == -3) {
				oWin = true;
				return true;
			}
		}

		// diagonal win
		// top right -> bottom left
		for(int i = board.length - 1; i > 1; i--) {
			for(int j = 0; j < 2; j++) {
				if(board[i][j] + board[i - 1][j + 1] + board[i - 2][j + 2] == 3) {
					xWin = true;
					return true;
				}
				if(board[i][j] + board[i - 1][j + 1] + board[i - 2][j + 2] == -3) {
					oWin = true;
					return true;
				}
			}
		}
		
		// top left -> bottom right
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				if(board[i][j] + board[i + 1][j + 1] + board[i + 2][j + 2] == 3) {
					xWin = true;
					return true;
				}
				if(board[i][j] + board[i + 1][j + 1] + board[i + 2][j + 2] == -3) {
					oWin = true;
					return true;
				}
			}
		}
		return false;
	}

	// prints the board in the console and where the user clicked
	public void printBoard() {
		for(int row = 0; row < board.length; row++) {
			for(int column = 0; column < board[row].length; column++) {
				
				System.out.print(board[row][column] + " | ");
			}
			System.out.println(" ");
		}
		System.out.println("\n");
	}

	public void mouseClicked(MouseEvent e) {
		int r = e.getY()/100;
		int c = e.getX()/100;
		
		if(board[r][c] == 0 && !checkWinner()) {
			if (turn == 1) {
				System.out.println("X clicked " + e.getX() + ", " + e.getY());
				System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
			}
			else if (turn == -1) {
				System.out.println("O clicked " + e.getX() + ", " + e.getY());
				System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
			}
			
			
			board[r][c] = turn;
			turn = -turn;
			
			printBoard();
		}
		
		this.repaint();
	}

	public void mousePressed(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}