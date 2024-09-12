package Snake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;




import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY = 100;
	final int x[]= new int[GAME_UNITS];
	final int y[]= new int[GAME_UNITS];
	int BodyParts = 1;
	int eaten ;
	int ScoreX;
	int ScoreY;
	char direction ='R';
	boolean running = false;
	Timer timer;
	Random random;
	
	
  GamePanel(){
	random = new Random();
	this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
	this.setBackground(Color.black);
	this.setFocusable(true);
	this.addKeyListener(new MyKeyAdapter());
	startGame();
  }
  public void startGame() {
	  newFruit();
	  running = true;
	  timer = new Timer(DELAY,this);
	  timer.start();
	  
	  
	  
  }
  
 public void paintComponent(Graphics g) {
       super.paintComponent(g);
      draw(g);

  }public void draw(Graphics g) {
	  
	  
	  if(running) {
	  /*for(int i = 0 ;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
		  g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
		  g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
	  }
	 */ 
	  
	  g.setColor(Color.red);
	  g.fillOval(ScoreX,ScoreY,UNIT_SIZE,UNIT_SIZE);
	  
	  for(int i = 0;i<BodyParts ;i++) {
		  if(i ==0) {
			  g.setColor(Color.blue);
			 
			  g.fillArc(x[i], y[i], UNIT_SIZE, UNIT_SIZE, 40,300);
		  }
		  else {
			  g.setColor(new Color(45,180,0));
			  //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			  g.fillOval(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
			 
			  
		  }
	  }
	  g.setColor(Color.red);
	  g.setFont(new Font("Ink Free",Font.BOLD, 20));
	  FontMetrics metrics = getFontMetrics(g.getFont());
	  g.drawString("SCORE : " + eaten, (SCREEN_WIDTH - metrics.stringWidth("SCORE : " + eaten))/2 ,g.getFont().getSize());
	  
	  }
	  else {
		  GameOver(g);
		  
	  }
	  
  }
  public void newFruit() {
	  ScoreX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
	  ScoreY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	  
  }
  public void move() {
	  for(int i = BodyParts;i>0;i--) {
		  x[i] = x[i-1];
		  y[i] = y[i-1];
		  
	  }
	  
	  switch(direction) {
	  case 'U':
		  y[0] = y[0] - UNIT_SIZE;
	  break;
	  
	  case'D':
	  y[0] = y[0] + UNIT_SIZE;
	  break;
	  
	  case 'L':
	  x[0] = x[0] - UNIT_SIZE;
	  break;
	  
	  case 'R':
	  x[0] = x[0] + UNIT_SIZE;
	  break;
	  }
	  
  }
  
  public void CheckScore() {
	  
	  if((x[0] == ScoreX) && (y[0] == ScoreY)) {
		  BodyParts++;
		  eaten++;
		  newFruit();
		  
	  }
	  
	  
  }
  public void checkCollision() {
	  for(int i = BodyParts;i>0;i--) {
		  if((x[0] == x[i])&& (y[0]== y[i])) {
			  running = false;
		  }
	  }
	  if((x[0] < 0) ||( x[0] >  SCREEN_WIDTH )||(y[0] < 0) || (y[0] > SCREEN_HEIGHT) ) {
		  running = false;
	  }
	  if(!running) {
		  timer.stop();
		  
	  }
	  
  }
  public void GameOver(Graphics g) {
	  g.setColor(Color.red);
	  g.setFont(new Font("Ink Free",Font.BOLD, 30));
	  FontMetrics metrics1 = getFontMetrics(g.getFont());
	  g.drawString("SCORE : " + eaten, (SCREEN_WIDTH - metrics1.stringWidth("SCORE : " + eaten))/2 ,g.getFont().getSize());
	  g.setColor(Color.red);
	  g.setFont(new Font("Ink Free",Font.BOLD, 80));
	  FontMetrics metrics2 = getFontMetrics(g.getFont());
	  g.drawString("GAME OVER", (SCREEN_WIDTH - metrics2.stringWidth("GAME OVER"))/2 ,SCREEN_HEIGHT/2);
	  
	  
  }
  
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			move();
			CheckScore();
			checkCollision();
			
		}
		repaint();
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction = 'L';
				}break;
				
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
				}break;
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
				}break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
				}break;
			}
		}
		
	}
}
