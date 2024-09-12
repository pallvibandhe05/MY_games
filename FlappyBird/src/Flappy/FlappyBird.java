package Flappy;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.JFrame;

public class FlappyBird extends JPanel {

	int BoardWidth = 360;
	int BoardHeight = 640;
	Image bgimageImg;
	Image bottomPipeImg;
	Image topPipeImg;
	Image birdImg;
	
	
	
	FlappyBird(){
	setPreferredSize(new Dimension(BoardWidth,BoardHeight));
	//setBackground(Color.blue);
	
	bgimageImg = new ImageIcon(getClass().getResource("bg2.png")).getImage();
	birdImg = new ImageIcon(getClass().getResource("bird.png")).getImage();
	topPipeImg = new ImageIcon(getClass().getResource("toppillar.png")).getImage();
	bottomPipeImg = new ImageIcon(getClass().getResource("bottompillar.png")).getImage();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		g.drawImage(bgimageImg,0,0,BoardWidth,BoardHeight, null);

		
	}
}
