package Flappy;

import javax.swing.JFrame;
import javax.swing.*;


public class App {

	public static void main(String[] args) throws Exception {
      int BoardWidth = 360;
      int BoardHeight = 640;
      
      JFrame frame = new JFrame("Flappy Bird");
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setSize(BoardWidth,BoardHeight);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      FlappyBird flappybird = new FlappyBird();
      frame.add(flappybird);
      frame.pack();
      frame.setVisible(true);
	}

}
