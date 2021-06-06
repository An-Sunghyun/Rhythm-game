package game1;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

//set and materialize all the notes to play game
public class Note extends Thread {
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/node.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.EASY_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean process = true;
	Score score;
	String difficulty;

	public String getNoteType() {
		return noteType;
	}

	public boolean isProcessing() {
		return process;
	}

	public void close() {
		process = false;
	}
	
	public Note(String noteType, Score score,String difficulty) {
		this.score = score;
		this.difficulty = difficulty;
		if (noteType.equals("S")) {
			x = 228;
		} else if (noteType.equals("D")) {
			x = 332;
		} else if (noteType.equals("F")) {
			x = 436;
		} else if (noteType.equals("Space")) {
			x = 540;
		} else if (noteType.equals("J")) {
			x = 744;
		} else if (noteType.equals("K")) {
			x = 848;
		} else if (noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}

	public void frameDraw(Graphics2D g) {
		if (!noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
		} else {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}

	public void easydrop() {
		y += Main.EASY_SPEED;
		if (y > 620) {
			System.out.println("Miss");
			close();
		}
	}
	public void harddrop() {
		y += Main.HARD_SPEED;
		if (y > 620) {
			System.out.println("Miss");
			close();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				if(difficulty.equals("Easy"))
				easydrop();
				else
					harddrop();
				
				if (process) {
					Thread.sleep(Main.SLEEP_TIME);
				} else {
					interrupt();
					break;
				}
				Thread.sleep(Main.SLEEP_TIME);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public String judge() {
		if (y > 613) {
			close();
			score.setScore(10);
			return "Late";
		} else if (y >= 600) {
			close();
			score.setScore(30);
			return "Good";
		} else if (y >= 587) {
			close();
			score.setScore(50);
			return "Great";
		} else if (y >= 573) {
			close();
			score.setScore(100);
			return "Perfect";
		} else if (y >= 565) {
			close();
			score.setScore(50);
			return "Great";
		} else if (y >= 550) {
			close();
			score.setScore(30);
			return "Good";
		} else if (y >= 535) {
			close();
			score.setScore(10);
			return "Early";
		}
		return "None";
	}

	public int getY() {
		return y;
	}

}
