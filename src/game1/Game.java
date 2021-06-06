package game1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

//Class that actually runs the game function.

public class Game extends Thread {

	// game playing component image
	private Image notePathLineImage = new ImageIcon(Main.class.getResource("../images/notePathLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/JudgementLine.png")).getImage();
	private Image gameGraphImage = new ImageIcon(Main.class.getResource("../images/gameGraph.png")).getImage();
	private Image notePathSImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathDImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathFImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathSpaceImage1 = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathSpaceImage2 = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathJImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathKImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathLImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image scorebackgroundImage = new ImageIcon(Main.class.getResource("../images/scorebackground.png")).getImage();
	private Image effect1Image;
	private Image effect2Image;
	private Image judgeImage;

	// KeyImage(S,D,F,Space,J,K,L)
	private Image keySImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	private Image keyDImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	private Image keyFImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	private Image keySpaceImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	private Image keyJImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	private Image keyKImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	private Image keyLImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();

	private String musicTitle;
	public String difficulty;
	public String titleName;
	private Music gameMusic;
	private int playtime;

	Score score = new Score();

	// Array that manages all of notes
	ArrayList<Note> noteList = new ArrayList<Note>();

	// Creator Setting
	public Game(String titleName, String difficulty, String musicTitle,int playtime) {
		this.difficulty = difficulty;
		this.titleName = titleName;
		this.musicTitle = musicTitle;
		this.playtime = playtime;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void frameDraw(Graphics2D g) {
		g.drawImage(notePathSImage, 228, 30, null);
		g.drawImage(notePathDImage, 332, 30, null);
		g.drawImage(notePathFImage, 436, 30, null);
		g.drawImage(notePathSpaceImage1, 540, 30, null);
		g.drawImage(notePathSpaceImage2, 640, 30, null);
		g.drawImage(notePathJImage, 744, 30, null);
		g.drawImage(notePathKImage, 848, 30, null);
		g.drawImage(notePathLImage, 952, 30, null);
		g.drawImage(notePathLineImage, 224, 30, null);
		g.drawImage(notePathLineImage, 328, 30, null);
		g.drawImage(notePathLineImage, 432, 30, null);
		g.drawImage(notePathLineImage, 536, 30, null);
		g.drawImage(notePathLineImage, 740, 30, null);
		g.drawImage(notePathLineImage, 844, 30, null);
		g.drawImage(notePathLineImage, 948, 30, null);
		g.drawImage(notePathLineImage, 1052, 30, null);
		g.drawImage(gameGraphImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);

		// Make all of notes in the frame
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();
			}
			if (!note.isProcessing()) {
				noteList.remove(i);
				i--;
			} else {
				note.frameDraw(g);
			}
		}

		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.white);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("SPACE", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawImage(effect1Image, 470, 430, null);
		g.drawImage(judgeImage, 450, 450, null);
		g.drawString(score.getScore(), 565, 702);

		g.drawImage(keySImage, 228, 580, null);
		g.drawImage(keyDImage, 332, 580, null);
		g.drawImage(keyFImage, 436, 580, null);
		g.drawImage(keySpaceImage, 540, 580, null);
		g.drawImage(keySpaceImage, 640, 580, null);
		g.drawImage(keyJImage, 744, 580, null);
		g.drawImage(keyKImage, 848, 580, null);
		g.drawImage(keyLImage, 952, 580, null);
		
		
	}
	
	//Method that shows result including grade and score
	public void resultFrame(Graphics2D g) {
		
		String grade=null;
		int totalScore = Integer.parseInt(score.getScore());
		if(totalScore > (300*100*0.9)) {
			 grade = "S";
		}else if(totalScore > (300*100*0.6)) {
		     grade = "A";
		}else if(totalScore > (300*100*0.4)) {
			 grade = "B";
		}else if(totalScore >= 0) {
			 grade = "C";
		}
		g.drawImage(scorebackgroundImage, 253, 45, null);
		g.setFont(new Font("Arial", Font.BOLD, 100));
		g.setColor(Color.white);
		g.drawString(score.getScore(), 500, 290);
		g.setColor(Color.pink);
		g.drawString(grade, 600, 400);
		
	}
	
	
	public void pressSBtn() {
		judge("S");
		notePathSImage = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		keySImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseSBtn() {
		notePathSImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
		keySImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	}

	public void pressDBtn() {
		judge("D");
		notePathDImage = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		keyDImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseDBtn() {
		notePathDImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
		keyDImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	}

	public void pressFBtn() {
		judge("F");
		notePathFImage = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		keyFImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseFBtn() {
		notePathFImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
		keyFImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	}

	public void pressJBtn() {
		judge("J");
		notePathJImage = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		keyJImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseJBtn() {
		notePathJImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
		keyJImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	}

	public void pressKBtn() {
		judge("K");
		notePathKImage = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		keyKImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseKBtn() {
		notePathKImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
		keyKImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	}

	public void pressLBtn() {
		judge("L");
		notePathLImage = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		keyLImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseLBtn() {
		notePathLImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
		keyLImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	}

	public void pressSpaceBar() {
		judge("Space");
		notePathSpaceImage1 = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		notePathSpaceImage2 = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		keySpaceImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}

	public void releaseSpaceBar() {
		notePathSpaceImage1 = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
		notePathSpaceImage2 = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
		keySpaceImage = new ImageIcon(Main.class.getResource("../images/keyBasic.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	// Materialize notes and Make notes fall
	public void dropNotes(String titleName) {
		Beat[] beats = null;

		if (titleName.equals("Existence Proof") && difficulty.equals("Hard")) {
			int startTime = 18000 - Main.REACH_TIME;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime + gap * 1, "F"), new Beat(startTime + gap * 5, "K"),
					new Beat(startTime + gap * 7, "F"), new Beat(startTime + gap * 10, "K"),
					new Beat(startTime + gap * 11, "K"), new Beat(startTime + gap * 13, "S"),
					new Beat(startTime + gap * 16, "K"), new Beat(startTime + gap * 17, "K"),
					new Beat(startTime + gap * 18, "F"), new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 21, "S"), new Beat(startTime + gap * 22, "F"),
					new Beat(startTime + gap * 24, "F"), new Beat(startTime + gap * 26, "K"),
					new Beat(startTime + gap * 27, "K"), new Beat(startTime + gap * 30, "F"),
					new Beat(startTime + gap * 31, "S"), new Beat(startTime + gap * 32, "S"),
					new Beat(startTime + gap * 36, "D"), new Beat(startTime + gap * 37, "D"),
					new Beat(startTime + gap * 39, "K"), new Beat(startTime + gap * 42, "F"),
					new Beat(startTime + gap * 44, "K"), new Beat(startTime + gap * 46, "S"),
					new Beat(startTime + gap * 50, "F"), new Beat(startTime + gap * 52, "D"),
					new Beat(startTime + gap * 53, "L"), new Beat(startTime + gap * 56, "J"),
					new Beat(startTime + gap * 58, "J"), new Beat(startTime + gap * 60, "S"),
					new Beat(startTime + gap * 62, "S"), new Beat(startTime + gap * 64, "K"),
					new Beat(startTime + gap * 66, "K"), new Beat(startTime + gap * 69, "S"),
					new Beat(startTime + gap * 73, "F"), new Beat(startTime + gap * 75, "F"),
					new Beat(startTime + gap * 78, "K"), new Beat(startTime + gap * 80, "K"),
					new Beat(startTime + gap * 81, "D"), new Beat(startTime + gap * 83, "J"),
					new Beat(startTime + gap * 85, "S"), new Beat(startTime + gap * 86, "K"),
					new Beat(startTime + gap * 97, "Space"), new Beat(startTime + gap * 99, "J"),
					new Beat(startTime + gap * 100, "S"), new Beat(startTime + gap * 102, "D"),
					new Beat(startTime + gap * 104, "D"), new Beat(startTime + gap * 106, "F"),
					new Beat(startTime + gap * 110, "D"), new Beat(startTime + gap * 115, "S"),
					new Beat(startTime + gap * 120, "F"), new Beat(startTime + gap * 124, "F"),
					new Beat(startTime + gap * 126, "K"), new Beat(startTime + gap * 127, "Space"),
					new Beat(startTime + gap * 129, "F"), new Beat(startTime + gap * 130, "K"),
					new Beat(startTime + gap * 132, "K"), new Beat(startTime + gap * 136, "D"),
					new Beat(startTime + gap * 137, "D"), new Beat(startTime + gap * 139, "K"),
					new Beat(startTime + gap * 142, "F"), new Beat(startTime + gap * 144, "F"),
					new Beat(startTime + gap * 146, "K"), new Beat(startTime + gap * 150, "F"),
					new Beat(startTime + gap * 152, "J"), new Beat(startTime + gap * 153, "F"),
					new Beat(startTime + gap * 156, "J"), new Beat(startTime + gap * 158, "F"),
					new Beat(startTime + gap * 10, "K"), new Beat(startTime + gap * 160, "S"),
					new Beat(startTime + gap * 162, "S"), new Beat(startTime + gap * 164, "K"),
					new Beat(startTime + gap * 166, "K"), new Beat(startTime + gap * 169, "Space"),
					new Beat(startTime + gap * 170, "J"), new Beat(startTime + gap * 171, "S"),
					new Beat(startTime + gap * 174, "K"), new Beat(startTime + gap * 176, "F"),
					new Beat(startTime + gap * 178, "D"), new Beat(startTime + gap * 181, "F"),
					new Beat(startTime + gap * 182, "K"), new Beat(startTime + gap * 183, "J"),
					new Beat(startTime + gap * 186, "K"), new Beat(startTime + gap * 190, "D"),
					new Beat(startTime + gap * 194, "Space"), new Beat(startTime + gap * 198, "S"),
					new Beat(startTime + gap * 205, "F"), new Beat(startTime + gap * 212, "D"),
					new Beat(startTime + gap * 216, "F"), new Beat(startTime + gap * 219, "K"),
					new Beat(startTime + gap * 220, "F"), new Beat(startTime + gap * 224, "Space"),
					new Beat(startTime + gap * 225, "K"), new Beat(startTime + gap * 227, "K"),
					new Beat(startTime + gap * 229, "F"), new Beat(startTime + gap * 230, "S"),
					new Beat(startTime + gap * 232, "K"), new Beat(startTime + gap * 236, "D"),
					new Beat(startTime + gap * 237, "F"), new Beat(startTime + gap * 239, "K"),
					new Beat(startTime + gap * 242, "F"), new Beat(startTime + gap * 243, "J"),
					new Beat(startTime + gap * 246, "K"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 251, "D"), new Beat(startTime + gap * 253, "L"),
					new Beat(startTime + gap * 256, "J"), new Beat(startTime + gap * 257, "K"),
					new Beat(startTime + gap * 260, "S"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 263, "F"), new Beat(startTime + gap * 266, "K"),
					new Beat(startTime + gap * 269, "S"), new Beat(startTime + gap * 270, "K"),
					new Beat(startTime + gap * 271, "S"), new Beat(startTime + gap * 274, "K"),
					new Beat(startTime + gap * 275, "K"), new Beat(startTime + gap * 278, "D"),
					new Beat(startTime + gap * 281, "F"), new Beat(startTime + gap * 282, "F"),
					new Beat(startTime + gap * 283, "J"), new Beat(startTime + gap * 286, "K"),
					new Beat(startTime + gap * 287, "K"), new Beat(startTime + gap * 297, "Space"),
					new Beat(startTime + gap * 300, "S"), new Beat(startTime + gap * 301, "K"),
					new Beat(startTime + gap * 302, "D"), new Beat(startTime + gap * 306, "F"),
					new Beat(startTime + gap * 307, "K"), new Beat(startTime + gap * 310, "J"),
					new Beat(startTime + gap * 320, "S"), new Beat(startTime + gap * 321, "J"),
					new Beat(startTime + gap * 322, "L"), new Beat(startTime + gap * 324, "F"),
					new Beat(startTime + gap * 326, "F"), new Beat(startTime + gap * 327, "K"),
					new Beat(startTime + gap * 329, "F"), new Beat(startTime + gap * 330, "J"),
					new Beat(startTime + gap * 332, "K"), new Beat(startTime + gap * 336, "D"),
					new Beat(startTime + gap * 337, "S"), new Beat(startTime + gap * 339, "K"),
					new Beat(startTime + gap * 342, "F"), new Beat(startTime + gap * 343, "F"),
					new Beat(startTime + gap * 346, "K"), new Beat(startTime + gap * 350, "F"),
					new Beat(startTime + gap * 351, "K"), new Beat(startTime + gap * 353, "L"),
					new Beat(startTime + gap * 356, "J"), new Beat(startTime + gap * 357, "K"),
					new Beat(startTime + gap * 360, "S"), new Beat(startTime + gap * 362, "S"),
					new Beat(startTime + gap * 363, "F"), new Beat(startTime + gap * 366, "K"),
					new Beat(startTime + gap * 369, "L"), new Beat(startTime + gap * 370, "D"),
					new Beat(startTime + gap * 371, "S"), new Beat(startTime + gap * 374, "K"),
					new Beat(startTime + gap * 375, "F"), new Beat(startTime + gap * 378, "D"),
					new Beat(startTime + gap * 381, "F"), new Beat(startTime + gap * 382, "K"),
					new Beat(startTime + gap * 383, "J"), new Beat(startTime + gap * 384, "Space"),
					new Beat(startTime + gap * 385, "F"), new Beat(startTime + gap * 388, "S"),
					new Beat(startTime + gap * 392, "D"), new Beat(startTime + gap * 393, "J"),
					new Beat(startTime + gap * 396, "F"), new Beat(startTime + gap * 400, "S"),
					new Beat(startTime + gap * 401, "K"), new Beat(startTime + gap * 404, "F"),
					new Beat(startTime + gap * 407, "K"), new Beat(startTime + gap * 408, "L"),
					new Beat(startTime + gap * 410, "F"), new Beat(startTime + gap * 412, "K"),
					new Beat(startTime + gap * 413, "S"), new Beat(startTime + gap * 416, "D"),
					new Beat(startTime + gap * 419, "K"), new Beat(startTime + gap * 420, "F"),
					new Beat(startTime + gap * 422, "F"), new Beat(startTime + gap * 426, "J"),
					new Beat(startTime + gap * 427, "D"), new Beat(startTime + gap * 430, "F"),
					new Beat(startTime + gap * 433, "L"), new Beat(startTime + gap * 434, "K"),
					new Beat(startTime + gap * 436, "J"), new Beat(startTime + gap * 440, "S"),
					new Beat(startTime + gap * 441, "F"), new Beat(startTime + gap * 442, "F"),
					new Beat(startTime + gap * 446, "K"), new Beat(startTime + gap * 447, "J"),
					new Beat(startTime + gap * 449, "S"), new Beat(startTime + gap * 455, "F"),
					new Beat(startTime + gap * 456, "K"), new Beat(startTime + gap * 458, "K"),
					new Beat(startTime + gap * 459, "D"), new Beat(startTime + gap * 460, "F"),
					new Beat(startTime + gap * 463, "J"), new Beat(startTime + gap * 466, "K"),
					new Beat(startTime + gap * 467, "K"), new Beat(startTime + gap * 477, "Space"),
					new Beat(startTime + gap * 480, "S"), new Beat(startTime + gap * 482, "F"),
					new Beat(startTime + gap * 482, "D"), new Beat(startTime + gap * 486, "F"),
					new Beat(startTime + gap * 487, "J"), new Beat(startTime + gap * 490, "D"),
					new Beat(startTime + gap * 493, "F"), new Beat(startTime + gap * 494, "F"),
					new Beat(startTime + gap * 494, "S"), new Beat(startTime + gap * 497, "Space"),
					new Beat(startTime + gap * 498, "F"), new Beat(startTime + gap * 499, "F"),
					new Beat(startTime + gap * 502, "K"), new Beat(startTime + gap * 503, "S"),
					new Beat(startTime + gap * 506, "D"), new Beat(startTime + gap * 509, "L"),
					new Beat(startTime + gap * 510, "K"), new Beat(startTime + gap * 512, "F"),
					new Beat(startTime + gap * 516, "K"), new Beat(startTime + gap * 517, "F"),
					new Beat(startTime + gap * 520, "F"), new Beat(startTime + gap * 523, "D"),
					new Beat(startTime + gap * 524, "S"), new Beat(startTime + gap * 526, "J"),
					new Beat(startTime + gap * 530, "S"), new Beat(startTime + gap * 531, "D"),
					new Beat(startTime + gap * 532, "F"), new Beat(startTime + gap * 536, "K"),
					new Beat(startTime + gap * 537, "F"), new Beat(startTime + gap * 539, "Space"),
					new Beat(startTime + gap * 541, "S"), new Beat(startTime + gap * 542, "K"),
					new Beat(startTime + gap * 547, "K"), new Beat(startTime + gap * 548, "D"),
					new Beat(startTime + gap * 549, "J"), new Beat(startTime + gap * 551, "F"),
					new Beat(startTime + gap * 553, "J"), new Beat(startTime + gap * 554, "F"),
					new Beat(startTime + gap * 556, "K"), new Beat(startTime + gap * 564, "Space"),
					new Beat(startTime + gap * 565, "K"), new Beat(startTime + gap * 568, "S"),
					new Beat(startTime + gap * 572, "D"), new Beat(startTime + gap * 573, "L"),
					new Beat(startTime + gap * 576, "F"), new Beat(startTime + gap * 580, "F"),
					new Beat(startTime + gap * 581, "F"), new Beat(startTime + gap * 584, "Space"),
					new Beat(startTime + gap * 587, "K"), new Beat(startTime + gap * 588, "S"),
					new Beat(startTime + gap * 589, "F"), new Beat(startTime + gap * 592, "K"),
					new Beat(startTime + gap * 593, "K"), new Beat(startTime + gap * 596, "D"),
					new Beat(startTime + gap * 599, "K"), new Beat(startTime + gap * 600, "D"),
					new Beat(startTime + gap * 602, "F"), new Beat(startTime + gap * 606, "K"),
					new Beat(startTime + gap * 607, "K"), new Beat(startTime + gap * 610, "F"),
					new Beat(startTime + gap * 613, "L"), new Beat(startTime + gap * 614, "F"),
					new Beat(startTime + gap * 616, "J"), new Beat(startTime + gap * 620, "S"),
					new Beat(startTime + gap * 621, "J"), new Beat(startTime + gap * 622, "S"),
					new Beat(startTime + gap * 626, "K"), new Beat(startTime + gap * 627, "L"),
					new Beat(startTime + gap * 629, "S"), new Beat(startTime + gap * 631, "S"),
					new Beat(startTime + gap * 632, "Space"), new Beat(startTime + gap * 634, "K"),
					new Beat(startTime + gap * 638, "D"), new Beat(startTime + gap * 639, "F"),
					new Beat(startTime + gap * 641, "F"), new Beat(startTime + gap * 643, "J"),
					new Beat(startTime + gap * 644, "D"), new Beat(startTime + gap * 646, "K"),
					new Beat(startTime + gap * 647, "Space"), new Beat(startTime + gap * 648, "K"),
					new Beat(startTime + gap * 650, "S"), new Beat(startTime + gap * 652, "D"),
					new Beat(startTime + gap * 653, "L"), new Beat(startTime + gap * 656, "F"),
					new Beat(startTime + gap * 660, "D"), new Beat(startTime + gap * 661, "J"),
					new Beat(startTime + gap * 665, "F"), new Beat(startTime + gap * 671, "F"),
					new Beat(startTime + gap * 672, "F"), new Beat(startTime + gap * 674, "F"),
					new Beat(startTime + gap * 677, "K"), new Beat(startTime + gap * 678, "K"),
					new Beat(startTime + gap * 679, "F"), new Beat(startTime + gap * 682, "K"),
					new Beat(startTime + gap * 683, "S"), new Beat(startTime + gap * 686, "D"),
					new Beat(startTime + gap * 689, "K"), new Beat(startTime + gap * 690, "D"),
					new Beat(startTime + gap * 692, "F"), new Beat(startTime + gap * 696, "K"),
					new Beat(startTime + gap * 697, "F"), new Beat(startTime + gap * 700, "F"),
					new Beat(startTime + gap * 703, "L"), new Beat(startTime + gap * 704, "K"),
					new Beat(startTime + gap * 706, "J"), new Beat(startTime + gap * 710, "S"),
					new Beat(startTime + gap * 711, "D"), new Beat(startTime + gap * 712, "S"),
					new Beat(startTime + gap * 716, "K"), new Beat(startTime + gap * 717, "F"),
					new Beat(startTime + gap * 719, "F"), new Beat(startTime + gap * 720, "K") };

		} else if (titleName.equals("Existence Proof") && difficulty.equals("Easy")) {
			int startTime = 18000 - Main.REACH_TIME;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime, "Space"), new Beat(startTime + gap * 24, "F"),
					new Beat(startTime + gap * 27, "K"), new Beat(startTime + gap * 30, "F"),
					new Beat(startTime + gap * 32, "K"), new Beat(startTime + gap * 36, "D"),
					new Beat(startTime + gap * 39, "K"), new Beat(startTime + gap * 42, "F"),
					new Beat(startTime + gap * 46, "K"), new Beat(startTime + gap * 50, "F"),
					new Beat(startTime + gap * 53, "L"), new Beat(startTime + gap * 56, "J"),
					new Beat(startTime + gap * 60, "S"), new Beat(startTime + gap * 62, "S"),
					new Beat(startTime + gap * 66, "K"), new Beat(startTime + gap * 69, "S"),
					new Beat(startTime + gap * 75, "F"), new Beat(startTime + gap * 78, "K"),
					new Beat(startTime + gap * 79, "D"), new Beat(startTime + gap * 83, "J"),
					new Beat(startTime + gap * 86, "K"), new Beat(startTime + gap * 97, "Space"),
					new Beat(startTime + gap * 100, "S"), new Beat(startTime + gap * 102, "D"),
					new Beat(startTime + gap * 106, "F"), new Beat(startTime + gap * 110, "D"),
					new Beat(startTime + gap * 120, "F"), new Beat(startTime + gap * 124, "F"),
					new Beat(startTime + gap * 127, "Space"), new Beat(startTime + gap * 129, "F"),
					new Beat(startTime + gap * 132, "K"), new Beat(startTime + gap * 136, "D"),
					new Beat(startTime + gap * 139, "K"), new Beat(startTime + gap * 142, "F"),
					new Beat(startTime + gap * 146, "K"), new Beat(startTime + gap * 150, "F"),
					new Beat(startTime + gap * 153, "F"), new Beat(startTime + gap * 156, "J"),
					new Beat(startTime + gap * 160, "S"), new Beat(startTime + gap * 162, "S"),
					new Beat(startTime + gap * 166, "K"), new Beat(startTime + gap * 169, "Space"),
					new Beat(startTime + gap * 171, "S"), new Beat(startTime + gap * 174, "K"),
					new Beat(startTime + gap * 178, "D"), new Beat(startTime + gap * 181, "F"),
					new Beat(startTime + gap * 183, "J"), new Beat(startTime + gap * 186, "K"),
					new Beat(startTime + gap * 194, "Space"), new Beat(startTime + gap * 198, "S"),
					new Beat(startTime + gap * 212, "D"), new Beat(startTime + gap * 216, "F"),
					new Beat(startTime + gap * 220, "F"), new Beat(startTime + gap * 224, "Space"),
					new Beat(startTime + gap * 227, "K"), new Beat(startTime + gap * 229, "F"),
					new Beat(startTime + gap * 232, "K"), new Beat(startTime + gap * 236, "D"),
					new Beat(startTime + gap * 239, "K"), new Beat(startTime + gap * 242, "F"),
					new Beat(startTime + gap * 246, "K"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 253, "L"), new Beat(startTime + gap * 256, "J"),
					new Beat(startTime + gap * 260, "S"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 266, "K"), new Beat(startTime + gap * 269, "S"),
					new Beat(startTime + gap * 271, "S"), new Beat(startTime + gap * 274, "K"),
					new Beat(startTime + gap * 278, "D"), new Beat(startTime + gap * 281, "F"),
					new Beat(startTime + gap * 283, "J"), new Beat(startTime + gap * 286, "K"),
					new Beat(startTime + gap * 297, "Space"), new Beat(startTime + gap * 300, "S"),
					new Beat(startTime + gap * 302, "D"), new Beat(startTime + gap * 306, "F"),
					new Beat(startTime + gap * 310, "J"), new Beat(startTime + gap * 320, "S"),
					new Beat(startTime + gap * 322, "L"), new Beat(startTime + gap * 324, "F"),
					new Beat(startTime + gap * 327, "K"), new Beat(startTime + gap * 329, "F"),
					new Beat(startTime + gap * 332, "K"), new Beat(startTime + gap * 336, "D"),
					new Beat(startTime + gap * 339, "K"), new Beat(startTime + gap * 342, "F"),
					new Beat(startTime + gap * 346, "K"), new Beat(startTime + gap * 350, "F"),
					new Beat(startTime + gap * 353, "L"), new Beat(startTime + gap * 356, "J"),
					new Beat(startTime + gap * 360, "S"), new Beat(startTime + gap * 362, "S"),
					new Beat(startTime + gap * 366, "K"), new Beat(startTime + gap * 369, "L"),
					new Beat(startTime + gap * 371, "S"), new Beat(startTime + gap * 374, "K"),
					new Beat(startTime + gap * 378, "D"), new Beat(startTime + gap * 381, "F"),
					new Beat(startTime + gap * 383, "J"), new Beat(startTime + gap * 384, "Space"),
					new Beat(startTime + gap * 388, "S"), new Beat(startTime + gap * 392, "D"),
					new Beat(startTime + gap * 396, "F"), new Beat(startTime + gap * 400, "S"),
					new Beat(startTime + gap * 404, "F"), new Beat(startTime + gap * 407, "K"),
					new Beat(startTime + gap * 410, "F"), new Beat(startTime + gap * 412, "K"),
					new Beat(startTime + gap * 416, "D"), new Beat(startTime + gap * 419, "K"),
					new Beat(startTime + gap * 422, "F"), new Beat(startTime + gap * 426, "J"),
					new Beat(startTime + gap * 430, "F"), new Beat(startTime + gap * 433, "L"),
					new Beat(startTime + gap * 436, "J"), new Beat(startTime + gap * 440, "S"),
					new Beat(startTime + gap * 442, "F"), new Beat(startTime + gap * 446, "K"),
					new Beat(startTime + gap * 449, "S"), new Beat(startTime + gap * 455, "F"),
					new Beat(startTime + gap * 458, "K"), new Beat(startTime + gap * 459, "D"),
					new Beat(startTime + gap * 463, "J"), new Beat(startTime + gap * 466, "K"),
					new Beat(startTime + gap * 477, "Space"), new Beat(startTime + gap * 480, "S"),
					new Beat(startTime + gap * 482, "D"), new Beat(startTime + gap * 486, "F"),
					new Beat(startTime + gap * 490, "D"), new Beat(startTime + gap * 493, "F"),
					new Beat(startTime + gap * 494, "S"), new Beat(startTime + gap * 497, "Space"),
					new Beat(startTime + gap * 499, "F"), new Beat(startTime + gap * 502, "K"),
					new Beat(startTime + gap * 506, "D"), new Beat(startTime + gap * 509, "L"),
					new Beat(startTime + gap * 512, "F"), new Beat(startTime + gap * 516, "K"),
					new Beat(startTime + gap * 520, "F"), new Beat(startTime + gap * 523, "D"),
					new Beat(startTime + gap * 526, "J"), new Beat(startTime + gap * 530, "S"),
					new Beat(startTime + gap * 532, "F"), new Beat(startTime + gap * 536, "K"),
					new Beat(startTime + gap * 539, "Space"), new Beat(startTime + gap * 541, "S"),
					new Beat(startTime + gap * 547, "K"), new Beat(startTime + gap * 548, "D"),
					new Beat(startTime + gap * 551, "F"), new Beat(startTime + gap * 553, "J"),
					new Beat(startTime + gap * 556, "K"), new Beat(startTime + gap * 564, "Space"),
					new Beat(startTime + gap * 568, "S"), new Beat(startTime + gap * 572, "D"),
					new Beat(startTime + gap * 576, "F"), new Beat(startTime + gap * 580, "F"),
					new Beat(startTime + gap * 584, "Space"), new Beat(startTime + gap * 587, "K"),
					new Beat(startTime + gap * 589, "F"), new Beat(startTime + gap * 592, "K"),
					new Beat(startTime + gap * 596, "D"), new Beat(startTime + gap * 599, "K"),
					new Beat(startTime + gap * 602, "F"), new Beat(startTime + gap * 606, "K"),
					new Beat(startTime + gap * 610, "F"), new Beat(startTime + gap * 613, "L"),
					new Beat(startTime + gap * 616, "J"), new Beat(startTime + gap * 620, "S"),
					new Beat(startTime + gap * 622, "S"), new Beat(startTime + gap * 626, "K"),
					new Beat(startTime + gap * 629, "S"), new Beat(startTime + gap * 631, "S"),
					new Beat(startTime + gap * 634, "K"), new Beat(startTime + gap * 638, "D"),
					new Beat(startTime + gap * 641, "F"), new Beat(startTime + gap * 643, "J"),
					new Beat(startTime + gap * 646, "K"), new Beat(startTime + gap * 647, "Space"),
					new Beat(startTime + gap * 650, "S"), new Beat(startTime + gap * 652, "D"),
					new Beat(startTime + gap * 656, "F"), new Beat(startTime + gap * 660, "D"),
					new Beat(startTime + gap * 665, "F"), new Beat(startTime + gap * 671, "F"),
					new Beat(startTime + gap * 674, "F"), new Beat(startTime + gap * 677, "K"),
					new Beat(startTime + gap * 679, "F"), new Beat(startTime + gap * 682, "K"),
					new Beat(startTime + gap * 686, "D"), new Beat(startTime + gap * 689, "K"),
					new Beat(startTime + gap * 692, "F"), new Beat(startTime + gap * 696, "K"),
					new Beat(startTime + gap * 700, "F"), new Beat(startTime + gap * 703, "L"),
					new Beat(startTime + gap * 706, "J"), };

		} else if (titleName.equals("Red Swan") && difficulty.equals("Easy")) {
			int startTime = 9000 - Main.REACH_TIME;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime, "Space"), new Beat(startTime + gap * 24, "F"),
					new Beat(startTime + gap * 27, "K"), new Beat(startTime + gap * 30, "F"),
					new Beat(startTime + gap * 32, "K"), new Beat(startTime + gap * 36, "D"),
					new Beat(startTime + gap * 39, "K"), new Beat(startTime + gap * 42, "F"),
					new Beat(startTime + gap * 46, "K"), new Beat(startTime + gap * 50, "F"),
					new Beat(startTime + gap * 53, "L"), new Beat(startTime + gap * 56, "J"),
					new Beat(startTime + gap * 60, "S"), new Beat(startTime + gap * 62, "S"),
					new Beat(startTime + gap * 66, "K"), new Beat(startTime + gap * 69, "S"),
					new Beat(startTime + gap * 75, "F"), new Beat(startTime + gap * 78, "K"),
					new Beat(startTime + gap * 79, "D"), new Beat(startTime + gap * 83, "J"),
					new Beat(startTime + gap * 86, "K"), new Beat(startTime + gap * 97, "Space"),
					new Beat(startTime + gap * 100, "S"), new Beat(startTime + gap * 102, "D"),
					new Beat(startTime + gap * 106, "F"), new Beat(startTime + gap * 110, "D"),
					new Beat(startTime + gap * 120, "F"), new Beat(startTime + gap * 124, "F"),
					new Beat(startTime + gap * 127, "Space"), new Beat(startTime + gap * 129, "F"),
					new Beat(startTime + gap * 132, "K"), new Beat(startTime + gap * 136, "D"),
					new Beat(startTime + gap * 139, "K"), new Beat(startTime + gap * 142, "F"),
					new Beat(startTime + gap * 146, "K"), new Beat(startTime + gap * 150, "F"),
					new Beat(startTime + gap * 153, "F"), new Beat(startTime + gap * 156, "J"),
					new Beat(startTime + gap * 160, "S"), new Beat(startTime + gap * 162, "S"),
					new Beat(startTime + gap * 166, "K"), new Beat(startTime + gap * 169, "Space"),
					new Beat(startTime + gap * 171, "S"), new Beat(startTime + gap * 174, "K"),
					new Beat(startTime + gap * 178, "D"), new Beat(startTime + gap * 181, "F"),
					new Beat(startTime + gap * 183, "J"), new Beat(startTime + gap * 186, "K"),
					new Beat(startTime + gap * 194, "Space"), new Beat(startTime + gap * 198, "S"),
					new Beat(startTime + gap * 212, "D"), new Beat(startTime + gap * 216, "F"),
					new Beat(startTime + gap * 220, "F"), new Beat(startTime + gap * 224, "Space"),
					new Beat(startTime + gap * 227, "K"), new Beat(startTime + gap * 229, "F"),
					new Beat(startTime + gap * 232, "D"), new Beat(startTime + gap * 236, "D"),
					new Beat(startTime + gap * 239, "L"), new Beat(startTime + gap * 242, "F"),
					new Beat(startTime + gap * 246, "J"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 253, "L"), new Beat(startTime + gap * 256, "J"),
					new Beat(startTime + gap * 260, "S"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 266, "K"), new Beat(startTime + gap * 269, "S"),
					new Beat(startTime + gap * 271, "S"), new Beat(startTime + gap * 274, "K"),
					new Beat(startTime + gap * 278, "D"), new Beat(startTime + gap * 281, "F"),
					new Beat(startTime + gap * 283, "J"), new Beat(startTime + gap * 286, "K"),
					new Beat(startTime + gap * 297, "Space"), new Beat(startTime + gap * 300, "S"),
					new Beat(startTime + gap * 302, "D"), new Beat(startTime + gap * 306, "F"),
					new Beat(startTime + gap * 310, "J"), new Beat(startTime + gap * 320, "S"),
					new Beat(startTime + gap * 322, "L"), new Beat(startTime + gap * 324, "F"),
					new Beat(startTime + gap * 327, "K"), new Beat(startTime + gap * 329, "F"),
					new Beat(startTime + gap * 332, "K"), new Beat(startTime + gap * 336, "D"),
					new Beat(startTime + gap * 339, "K"), new Beat(startTime + gap * 342, "F"),
					new Beat(startTime + gap * 346, "K"), new Beat(startTime + gap * 350, "F"),
					new Beat(startTime + gap * 353, "L"), new Beat(startTime + gap * 356, "J"),
					new Beat(startTime + gap * 360, "S"), new Beat(startTime + gap * 362, "S"),
					new Beat(startTime + gap * 366, "K"), new Beat(startTime + gap * 369, "L"),
					new Beat(startTime + gap * 371, "S"), new Beat(startTime + gap * 374, "K"),
					new Beat(startTime + gap * 378, "D"), new Beat(startTime + gap * 381, "F"),
					new Beat(startTime + gap * 383, "J"), new Beat(startTime + gap * 384, "Space"),
					new Beat(startTime + gap * 388, "S"), new Beat(startTime + gap * 392, "D"),
					new Beat(startTime + gap * 396, "F"), new Beat(startTime + gap * 400, "S"),
					new Beat(startTime + gap * 404, "D"), new Beat(startTime + gap * 407, "K"),
					new Beat(startTime + gap * 410, "F"), new Beat(startTime + gap * 412, "L"),
					new Beat(startTime + gap * 416, "D"), new Beat(startTime + gap * 419, "K"),
					new Beat(startTime + gap * 422, "F"), new Beat(startTime + gap * 426, "J"),
					new Beat(startTime + gap * 430, "F"), new Beat(startTime + gap * 433, "L"),
					new Beat(startTime + gap * 436, "J"), new Beat(startTime + gap * 440, "S"),
					new Beat(startTime + gap * 442, "F"), new Beat(startTime + gap * 446, "K"),
					new Beat(startTime + gap * 449, "S"), new Beat(startTime + gap * 455, "F"),
					new Beat(startTime + gap * 458, "K"), new Beat(startTime + gap * 459, "D"),
					new Beat(startTime + gap * 463, "J"), new Beat(startTime + gap * 466, "K"),
					new Beat(startTime + gap * 477, "Space"), new Beat(startTime + gap * 480, "S"),
					new Beat(startTime + gap * 482, "D"), new Beat(startTime + gap * 486, "F"),
					new Beat(startTime + gap * 490, "L"), new Beat(startTime + gap * 493, "K"),
					new Beat(startTime + gap * 494, "S"), new Beat(startTime + gap * 497, "Space"),
					new Beat(startTime + gap * 499, "F"), new Beat(startTime + gap * 502, "K"),
					new Beat(startTime + gap * 506, "D"), new Beat(startTime + gap * 509, "L"),
					new Beat(startTime + gap * 512, "F"), new Beat(startTime + gap * 516, "K"),
					new Beat(startTime + gap * 520, "F"), new Beat(startTime + gap * 523, "D"),
					new Beat(startTime + gap * 526, "J"), new Beat(startTime + gap * 530, "S"),
					new Beat(startTime + gap * 532, "F"), new Beat(startTime + gap * 536, "K"),
					new Beat(startTime + gap * 539, "Space"), new Beat(startTime + gap * 541, "S"),
					new Beat(startTime + gap * 547, "K"), new Beat(startTime + gap * 548, "D"),
					new Beat(startTime + gap * 551, "F"), new Beat(startTime + gap * 553, "J"),
					new Beat(startTime + gap * 556, "K"), new Beat(startTime + gap * 564, "Space"),
					new Beat(startTime + gap * 568, "S"), new Beat(startTime + gap * 572, "D"),
					new Beat(startTime + gap * 576, "F"), new Beat(startTime + gap * 580, "F"),
					new Beat(startTime + gap * 584, "Space"), new Beat(startTime + gap * 587, "K"),
					new Beat(startTime + gap * 589, "F"), new Beat(startTime + gap * 592, "K"),
					new Beat(startTime + gap * 596, "D"), new Beat(startTime + gap * 599, "J"),
					new Beat(startTime + gap * 602, "F"), new Beat(startTime + gap * 606, "S"),
					new Beat(startTime + gap * 610, "D"), new Beat(startTime + gap * 613, "L"),
					new Beat(startTime + gap * 616, "J"), new Beat(startTime + gap * 620, "S"),
					new Beat(startTime + gap * 622, "S"), new Beat(startTime + gap * 626, "K"),
					new Beat(startTime + gap * 629, "S"), new Beat(startTime + gap * 631, "S"),
					new Beat(startTime + gap * 634, "K"), new Beat(startTime + gap * 638, "D"),
					new Beat(startTime + gap * 641, "F"), new Beat(startTime + gap * 643, "J"),
					new Beat(startTime + gap * 646, "K"), new Beat(startTime + gap * 647, "Space"),
					new Beat(startTime + gap * 650, "S"), new Beat(startTime + gap * 652, "D"),
					new Beat(startTime + gap * 656, "F"), new Beat(startTime + gap * 660, "D"),
					new Beat(startTime + gap * 665, "S"), new Beat(startTime + gap * 671, "F"),
					new Beat(startTime + gap * 674, "F"), new Beat(startTime + gap * 677, "K"),
					new Beat(startTime + gap * 679, "D"), new Beat(startTime + gap * 682, "S"),
					new Beat(startTime + gap * 686, "D"), new Beat(startTime + gap * 689, "K"),
					new Beat(startTime + gap * 692, "F"), new Beat(startTime + gap * 696, "D"),
					new Beat(startTime + gap * 700, "J"), new Beat(startTime + gap * 703, "L"),
					new Beat(startTime + gap * 706, "J"), };
		} else if (titleName.equals("Red Swan") && difficulty.equals("Hard")) {
			int startTime = 9000 - Main.REACH_TIME;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime + gap * 7, "F"), new Beat(startTime + gap * 10, "K"),
					new Beat(startTime + gap * 11, "K"), new Beat(startTime + gap * 13, "D"),
					new Beat(startTime + gap * 16, "K"), new Beat(startTime + gap * 17, "K"),
					new Beat(startTime + gap * 18, "F"), new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 21, "K"), new Beat(startTime + gap * 22, "F"),
					new Beat(startTime + gap * 24, "F"), new Beat(startTime + gap * 26, "K"),
					new Beat(startTime + gap * 27, "K"), new Beat(startTime + gap * 30, "F"),
					new Beat(startTime + gap * 31, "K"), new Beat(startTime + gap * 32, "S"),
					new Beat(startTime + gap * 36, "D"), new Beat(startTime + gap * 37, "K"),
					new Beat(startTime + gap * 39, "K"), new Beat(startTime + gap * 42, "F"),
					new Beat(startTime + gap * 44, "K"), new Beat(startTime + gap * 46, "S"),
					new Beat(startTime + gap * 50, "F"), new Beat(startTime + gap * 52, "K"),
					new Beat(startTime + gap * 53, "L"), new Beat(startTime + gap * 56, "J"),
					new Beat(startTime + gap * 58, "K"), new Beat(startTime + gap * 60, "S"),
					new Beat(startTime + gap * 62, "S"), new Beat(startTime + gap * 64, "K"),
					new Beat(startTime + gap * 66, "K"), new Beat(startTime + gap * 69, "S"),
					new Beat(startTime + gap * 73, "K"), new Beat(startTime + gap * 75, "F"),
					new Beat(startTime + gap * 78, "K"), new Beat(startTime + gap * 80, "K"),
					new Beat(startTime + gap * 81, "D"), new Beat(startTime + gap * 83, "J"),
					new Beat(startTime + gap * 85, "K"), new Beat(startTime + gap * 86, "K"),
					new Beat(startTime + gap * 97, "Space"), new Beat(startTime + gap * 99, "K"),
					new Beat(startTime + gap * 100, "S"), new Beat(startTime + gap * 102, "D"),
					new Beat(startTime + gap * 104, "K"), new Beat(startTime + gap * 106, "F"),
					new Beat(startTime + gap * 110, "D"), new Beat(startTime + gap * 115, "K"),
					new Beat(startTime + gap * 120, "F"), new Beat(startTime + gap * 124, "F"),
					new Beat(startTime + gap * 126, "K"), new Beat(startTime + gap * 127, "Space"),
					new Beat(startTime + gap * 129, "F"), new Beat(startTime + gap * 130, "K"),
					new Beat(startTime + gap * 132, "K"), new Beat(startTime + gap * 136, "D"),
					new Beat(startTime + gap * 137, "K"), new Beat(startTime + gap * 139, "K"),
					new Beat(startTime + gap * 142, "F"), new Beat(startTime + gap * 144, "K"),
					new Beat(startTime + gap * 146, "K"), new Beat(startTime + gap * 150, "F"),
					new Beat(startTime + gap * 152, "K"), new Beat(startTime + gap * 153, "F"),
					new Beat(startTime + gap * 156, "J"), new Beat(startTime + gap * 158, "K"),
					new Beat(startTime + gap * 10, "K"), new Beat(startTime + gap * 160, "S"),
					new Beat(startTime + gap * 162, "S"), new Beat(startTime + gap * 164, "K"),
					new Beat(startTime + gap * 166, "K"), new Beat(startTime + gap * 169, "Space"),
					new Beat(startTime + gap * 170, "K"), new Beat(startTime + gap * 171, "S"),
					new Beat(startTime + gap * 174, "K"), new Beat(startTime + gap * 176, "K"),
					new Beat(startTime + gap * 178, "D"), new Beat(startTime + gap * 181, "F"),
					new Beat(startTime + gap * 182, "K"), new Beat(startTime + gap * 183, "J"),
					new Beat(startTime + gap * 186, "K"), new Beat(startTime + gap * 190, "K"),
					new Beat(startTime + gap * 194, "Space"), new Beat(startTime + gap * 198, "S"),
					new Beat(startTime + gap * 205, "K"), new Beat(startTime + gap * 212, "D"),
					new Beat(startTime + gap * 216, "F"), new Beat(startTime + gap * 219, "K"),
					new Beat(startTime + gap * 220, "F"), new Beat(startTime + gap * 224, "Space"),
					new Beat(startTime + gap * 225, "K"), new Beat(startTime + gap * 227, "K"),
					new Beat(startTime + gap * 229, "F"), new Beat(startTime + gap * 230, "K"),
					new Beat(startTime + gap * 232, "K"), new Beat(startTime + gap * 236, "D"),
					new Beat(startTime + gap * 237, "K"), new Beat(startTime + gap * 239, "K"),
					new Beat(startTime + gap * 242, "F"), new Beat(startTime + gap * 243, "K"),
					new Beat(startTime + gap * 246, "K"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 251, "K"), new Beat(startTime + gap * 253, "L"),
					new Beat(startTime + gap * 256, "J"), new Beat(startTime + gap * 257, "K"),
					new Beat(startTime + gap * 260, "S"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 263, "K"), new Beat(startTime + gap * 266, "K"),
					new Beat(startTime + gap * 269, "S"), new Beat(startTime + gap * 270, "K"),
					new Beat(startTime + gap * 271, "S"), new Beat(startTime + gap * 274, "K"),
					new Beat(startTime + gap * 275, "K"), new Beat(startTime + gap * 278, "D"),
					new Beat(startTime + gap * 281, "F"), new Beat(startTime + gap * 282, "K"),
					new Beat(startTime + gap * 283, "J"), new Beat(startTime + gap * 286, "K"),
					new Beat(startTime + gap * 287, "K"), new Beat(startTime + gap * 297, "Space"),
					new Beat(startTime + gap * 300, "S"), new Beat(startTime + gap * 301, "K"),
					new Beat(startTime + gap * 302, "D"), new Beat(startTime + gap * 306, "F"),
					new Beat(startTime + gap * 307, "K"), new Beat(startTime + gap * 310, "J"),
					new Beat(startTime + gap * 320, "S"), new Beat(startTime + gap * 321, "K"),
					new Beat(startTime + gap * 322, "L"), new Beat(startTime + gap * 324, "F"),
					new Beat(startTime + gap * 326, "K"), new Beat(startTime + gap * 327, "K"),
					new Beat(startTime + gap * 329, "F"), new Beat(startTime + gap * 330, "K"),
					new Beat(startTime + gap * 332, "K"), new Beat(startTime + gap * 336, "D"),
					new Beat(startTime + gap * 337, "K"), new Beat(startTime + gap * 339, "K"),
					new Beat(startTime + gap * 342, "F"), new Beat(startTime + gap * 343, "K"),
					new Beat(startTime + gap * 346, "K"), new Beat(startTime + gap * 350, "F"),
					new Beat(startTime + gap * 351, "K"), new Beat(startTime + gap * 353, "L"),
					new Beat(startTime + gap * 356, "J"), new Beat(startTime + gap * 357, "K"),
					new Beat(startTime + gap * 360, "S"), new Beat(startTime + gap * 362, "S"),
					new Beat(startTime + gap * 363, "K"), new Beat(startTime + gap * 366, "K"),
					new Beat(startTime + gap * 369, "L"), new Beat(startTime + gap * 370, "K"),
					new Beat(startTime + gap * 371, "S"), new Beat(startTime + gap * 374, "K"),
					new Beat(startTime + gap * 375, "K"), new Beat(startTime + gap * 378, "D"),
					new Beat(startTime + gap * 381, "F"), new Beat(startTime + gap * 382, "K"),
					new Beat(startTime + gap * 383, "J"), new Beat(startTime + gap * 384, "Space"),
					new Beat(startTime + gap * 385, "K"), new Beat(startTime + gap * 388, "S"),
					new Beat(startTime + gap * 392, "D"), new Beat(startTime + gap * 393, "K"),
					new Beat(startTime + gap * 396, "F"), new Beat(startTime + gap * 400, "S"),
					new Beat(startTime + gap * 401, "K"), new Beat(startTime + gap * 404, "F"),
					new Beat(startTime + gap * 407, "K"), new Beat(startTime + gap * 408, "K"),
					new Beat(startTime + gap * 410, "F"), new Beat(startTime + gap * 412, "K"),
					new Beat(startTime + gap * 413, "K"), new Beat(startTime + gap * 416, "D"),
					new Beat(startTime + gap * 419, "K"), new Beat(startTime + gap * 420, "K"),
					new Beat(startTime + gap * 422, "F"), new Beat(startTime + gap * 426, "J"),
					new Beat(startTime + gap * 427, "K"), new Beat(startTime + gap * 430, "F"),
					new Beat(startTime + gap * 433, "L"), new Beat(startTime + gap * 434, "K"),
					new Beat(startTime + gap * 436, "J"), new Beat(startTime + gap * 440, "S"),
					new Beat(startTime + gap * 441, "K"), new Beat(startTime + gap * 442, "F"),
					new Beat(startTime + gap * 446, "K"), new Beat(startTime + gap * 447, "K"),
					new Beat(startTime + gap * 449, "S"), new Beat(startTime + gap * 455, "F"),
					new Beat(startTime + gap * 456, "K"), new Beat(startTime + gap * 458, "K"),
					new Beat(startTime + gap * 459, "D"), new Beat(startTime + gap * 460, "K"),
					new Beat(startTime + gap * 463, "J"), new Beat(startTime + gap * 466, "K"),
					new Beat(startTime + gap * 467, "K"), new Beat(startTime + gap * 477, "Space"),
					new Beat(startTime + gap * 480, "S"), new Beat(startTime + gap * 482, "K"),
					new Beat(startTime + gap * 482, "D"), new Beat(startTime + gap * 486, "F"),
					new Beat(startTime + gap * 487, "K"), new Beat(startTime + gap * 490, "D"),
					new Beat(startTime + gap * 493, "F"), new Beat(startTime + gap * 494, "K"),
					new Beat(startTime + gap * 494, "S"), new Beat(startTime + gap * 497, "Space"),
					new Beat(startTime + gap * 498, "K"), new Beat(startTime + gap * 499, "F"),
					new Beat(startTime + gap * 502, "K"), new Beat(startTime + gap * 503, "K"),
					new Beat(startTime + gap * 506, "D"), new Beat(startTime + gap * 509, "L"),
					new Beat(startTime + gap * 510, "K"), new Beat(startTime + gap * 512, "F"),
					new Beat(startTime + gap * 516, "K"), new Beat(startTime + gap * 517, "K"),
					new Beat(startTime + gap * 520, "F"), new Beat(startTime + gap * 523, "D"),
					new Beat(startTime + gap * 524, "K"), new Beat(startTime + gap * 526, "J"),
					new Beat(startTime + gap * 530, "S"), new Beat(startTime + gap * 531, "K"),
					new Beat(startTime + gap * 532, "F"), new Beat(startTime + gap * 536, "K"),
					new Beat(startTime + gap * 537, "K"), new Beat(startTime + gap * 539, "Space"),
					new Beat(startTime + gap * 541, "S"), new Beat(startTime + gap * 542, "K"),
					new Beat(startTime + gap * 547, "K"), new Beat(startTime + gap * 548, "D"),
					new Beat(startTime + gap * 549, "K"), new Beat(startTime + gap * 551, "F"),
					new Beat(startTime + gap * 553, "J"), new Beat(startTime + gap * 554, "K"),
					new Beat(startTime + gap * 556, "K"), new Beat(startTime + gap * 564, "Space"),
					new Beat(startTime + gap * 565, "K"), new Beat(startTime + gap * 568, "S"),
					new Beat(startTime + gap * 572, "D"), new Beat(startTime + gap * 573, "K"),
					new Beat(startTime + gap * 576, "F"), new Beat(startTime + gap * 580, "F"),
					new Beat(startTime + gap * 581, "K"), new Beat(startTime + gap * 584, "Space"),
					new Beat(startTime + gap * 587, "K"), new Beat(startTime + gap * 588, "K"),
					new Beat(startTime + gap * 589, "F"), new Beat(startTime + gap * 592, "K"),
					new Beat(startTime + gap * 593, "K"), new Beat(startTime + gap * 596, "D"),
					new Beat(startTime + gap * 599, "K"), new Beat(startTime + gap * 600, "K"),
					new Beat(startTime + gap * 602, "F"), new Beat(startTime + gap * 606, "K"),
					new Beat(startTime + gap * 607, "K"), new Beat(startTime + gap * 610, "F"),
					new Beat(startTime + gap * 613, "L"), new Beat(startTime + gap * 614, "K"),
					new Beat(startTime + gap * 616, "J"), new Beat(startTime + gap * 620, "S"),
					new Beat(startTime + gap * 621, "K"), new Beat(startTime + gap * 622, "S"),
					new Beat(startTime + gap * 626, "K"), new Beat(startTime + gap * 627, "K"),
					new Beat(startTime + gap * 629, "S"), new Beat(startTime + gap * 631, "S"),
					new Beat(startTime + gap * 632, "K"), new Beat(startTime + gap * 634, "K"),
					new Beat(startTime + gap * 638, "D"), new Beat(startTime + gap * 639, "K"),
					new Beat(startTime + gap * 641, "F"), new Beat(startTime + gap * 643, "J"),
					new Beat(startTime + gap * 644, "K"), new Beat(startTime + gap * 646, "K"),
					new Beat(startTime + gap * 647, "Space"), new Beat(startTime + gap * 648, "K"),
					new Beat(startTime + gap * 650, "S"), new Beat(startTime + gap * 652, "D"),
					new Beat(startTime + gap * 653, "K"), new Beat(startTime + gap * 656, "F"),
					new Beat(startTime + gap * 660, "D"), new Beat(startTime + gap * 661, "K"),
					new Beat(startTime + gap * 665, "F"), new Beat(startTime + gap * 671, "F"),
					new Beat(startTime + gap * 672, "K"), new Beat(startTime + gap * 674, "F"),
					new Beat(startTime + gap * 677, "K"), new Beat(startTime + gap * 678, "K"),
					new Beat(startTime + gap * 679, "F"), new Beat(startTime + gap * 682, "K"),
					new Beat(startTime + gap * 683, "K"), new Beat(startTime + gap * 686, "D"),
					new Beat(startTime + gap * 689, "K"), new Beat(startTime + gap * 690, "K"),
					new Beat(startTime + gap * 692, "F"), new Beat(startTime + gap * 696, "K"),
					new Beat(startTime + gap * 697, "K"), new Beat(startTime + gap * 700, "F"),
					new Beat(startTime + gap * 703, "L"), new Beat(startTime + gap * 704, "K"),
					new Beat(startTime + gap * 706, "J"), new Beat(startTime + gap * 710, "S"),
					new Beat(startTime + gap * 711, "K"), new Beat(startTime + gap * 712, "S"),
					new Beat(startTime + gap * 716, "K"), new Beat(startTime + gap * 717, "K"),
					new Beat(startTime + gap * 719, "F"), new Beat(startTime + gap * 720, "K"),
					new Beat(startTime + gap * 721, "S"), new Beat(startTime + gap * 722, "D"),
					new Beat(startTime + gap * 725, "F"), new Beat(startTime + gap * 728, "D"),
					new Beat(startTime + gap * 730, "K"), new Beat(startTime + gap * 733, "L"),
					new Beat(startTime + gap * 737, "F"), new Beat(startTime + gap * 737, "K"), };
		} else if (titleName.equals("Silhouette") && difficulty.equals("Easy")) {
			int startTime = 19500 - Main.REACH_TIME;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime, "Space"), new Beat(startTime + gap * 24, "F"),
					new Beat(startTime + gap * 27, "K"), new Beat(startTime + gap * 30, "F"),
					new Beat(startTime + gap * 32, "K"), new Beat(startTime + gap * 36, "D"),
					new Beat(startTime + gap * 39, "K"), new Beat(startTime + gap * 42, "F"),
					new Beat(startTime + gap * 46, "K"), new Beat(startTime + gap * 50, "F"),
					new Beat(startTime + gap * 53, "L"), new Beat(startTime + gap * 56, "J"),
					new Beat(startTime + gap * 60, "S"), new Beat(startTime + gap * 62, "S"),
					new Beat(startTime + gap * 66, "K"), new Beat(startTime + gap * 69, "S"),
					new Beat(startTime + gap * 75, "F"), new Beat(startTime + gap * 78, "K"),
					new Beat(startTime + gap * 79, "D"), new Beat(startTime + gap * 83, "J"),
					new Beat(startTime + gap * 86, "K"), new Beat(startTime + gap * 97, "Space"),
					new Beat(startTime + gap * 100, "S"), new Beat(startTime + gap * 102, "D"),
					new Beat(startTime + gap * 106, "F"), new Beat(startTime + gap * 110, "D"),
					new Beat(startTime + gap * 120, "F"), new Beat(startTime + gap * 124, "F"),
					new Beat(startTime + gap * 127, "Space"), new Beat(startTime + gap * 129, "F"),
					new Beat(startTime + gap * 132, "K"), new Beat(startTime + gap * 136, "D"),
					new Beat(startTime + gap * 139, "K"), new Beat(startTime + gap * 142, "F"),
					new Beat(startTime + gap * 146, "K"), new Beat(startTime + gap * 150, "F"),
					new Beat(startTime + gap * 153, "F"), new Beat(startTime + gap * 156, "J"),
					new Beat(startTime + gap * 160, "S"), new Beat(startTime + gap * 162, "S"),
					new Beat(startTime + gap * 166, "K"), new Beat(startTime + gap * 169, "Space"),
					new Beat(startTime + gap * 171, "S"), new Beat(startTime + gap * 174, "K"),
					new Beat(startTime + gap * 178, "D"), new Beat(startTime + gap * 181, "F"),
					new Beat(startTime + gap * 183, "J"), new Beat(startTime + gap * 186, "K"),
					new Beat(startTime + gap * 194, "Space"), new Beat(startTime + gap * 198, "S"),
					new Beat(startTime + gap * 212, "D"), new Beat(startTime + gap * 216, "F"),
					new Beat(startTime + gap * 220, "F"), new Beat(startTime + gap * 224, "Space"),
					new Beat(startTime + gap * 227, "K"), new Beat(startTime + gap * 229, "F"),
					new Beat(startTime + gap * 232, "K"), new Beat(startTime + gap * 236, "D"),
					new Beat(startTime + gap * 239, "K"), new Beat(startTime + gap * 242, "F"),
					new Beat(startTime + gap * 246, "K"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 253, "L"), new Beat(startTime + gap * 256, "J"),
					new Beat(startTime + gap * 260, "S"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 266, "K"), new Beat(startTime + gap * 269, "S"),
					new Beat(startTime + gap * 271, "S"), new Beat(startTime + gap * 274, "K"),
					new Beat(startTime + gap * 278, "D"), new Beat(startTime + gap * 281, "F"),
					new Beat(startTime + gap * 283, "J"), new Beat(startTime + gap * 286, "K"),
					new Beat(startTime + gap * 297, "Space"), new Beat(startTime + gap * 300, "S"),
					new Beat(startTime + gap * 302, "D"), new Beat(startTime + gap * 306, "F"),
					new Beat(startTime + gap * 310, "J"), new Beat(startTime + gap * 320, "S"),
					new Beat(startTime + gap * 322, "L"), new Beat(startTime + gap * 324, "F"),
					new Beat(startTime + gap * 327, "K"), new Beat(startTime + gap * 329, "F"),
					new Beat(startTime + gap * 332, "K"), new Beat(startTime + gap * 336, "D"),
					new Beat(startTime + gap * 339, "K"), new Beat(startTime + gap * 342, "F"),
					new Beat(startTime + gap * 346, "K"), new Beat(startTime + gap * 350, "F"),
					new Beat(startTime + gap * 353, "L"), new Beat(startTime + gap * 356, "J"),
					new Beat(startTime + gap * 360, "S"), new Beat(startTime + gap * 362, "S"),
					new Beat(startTime + gap * 366, "K"), new Beat(startTime + gap * 369, "L"),
					new Beat(startTime + gap * 371, "S"), new Beat(startTime + gap * 374, "K"),
					new Beat(startTime + gap * 378, "D"), new Beat(startTime + gap * 381, "F"),
					new Beat(startTime + gap * 383, "J"), new Beat(startTime + gap * 384, "Space"),
					new Beat(startTime + gap * 388, "S"), new Beat(startTime + gap * 392, "D"),
					new Beat(startTime + gap * 396, "F"), new Beat(startTime + gap * 400, "S"),
					new Beat(startTime + gap * 404, "F"), new Beat(startTime + gap * 407, "K"),
					new Beat(startTime + gap * 410, "F"), new Beat(startTime + gap * 412, "K"),
					new Beat(startTime + gap * 416, "D"), new Beat(startTime + gap * 419, "K"),
					new Beat(startTime + gap * 422, "F"), new Beat(startTime + gap * 426, "J"),
					new Beat(startTime + gap * 430, "F"), new Beat(startTime + gap * 433, "L"),
					new Beat(startTime + gap * 436, "J"), new Beat(startTime + gap * 440, "S"),
					new Beat(startTime + gap * 442, "F"), new Beat(startTime + gap * 446, "K"),
					new Beat(startTime + gap * 449, "S"), new Beat(startTime + gap * 455, "F"),
					new Beat(startTime + gap * 458, "K"), new Beat(startTime + gap * 459, "D"),
					new Beat(startTime + gap * 463, "J"), new Beat(startTime + gap * 466, "K"),
					new Beat(startTime + gap * 477, "Space"), new Beat(startTime + gap * 480, "S"),
					new Beat(startTime + gap * 482, "D"), new Beat(startTime + gap * 486, "F"),
					new Beat(startTime + gap * 490, "D"), new Beat(startTime + gap * 493, "F"),
					new Beat(startTime + gap * 494, "S"), new Beat(startTime + gap * 497, "Space"),
					new Beat(startTime + gap * 499, "F"), new Beat(startTime + gap * 502, "K"),
					new Beat(startTime + gap * 506, "D"), new Beat(startTime + gap * 509, "L"),
					new Beat(startTime + gap * 512, "F"), new Beat(startTime + gap * 516, "K"),
					new Beat(startTime + gap * 520, "F"), new Beat(startTime + gap * 523, "D"),
					new Beat(startTime + gap * 526, "J"), new Beat(startTime + gap * 530, "S"),
					new Beat(startTime + gap * 532, "F"), new Beat(startTime + gap * 536, "K"),
					new Beat(startTime + gap * 539, "Space"), new Beat(startTime + gap * 541, "S"),
					new Beat(startTime + gap * 547, "K"), new Beat(startTime + gap * 548, "D"),
					new Beat(startTime + gap * 551, "F"), new Beat(startTime + gap * 553, "J"),
					new Beat(startTime + gap * 556, "K"), new Beat(startTime + gap * 564, "Space"),
					new Beat(startTime + gap * 568, "S"), new Beat(startTime + gap * 572, "D"),
					new Beat(startTime + gap * 576, "F"), new Beat(startTime + gap * 580, "F"),
					new Beat(startTime + gap * 584, "Space"), new Beat(startTime + gap * 587, "K"),
					new Beat(startTime + gap * 589, "F"), new Beat(startTime + gap * 592, "K"),
					new Beat(startTime + gap * 596, "D"), new Beat(startTime + gap * 599, "K"),
					new Beat(startTime + gap * 602, "F"), new Beat(startTime + gap * 606, "K"),
					new Beat(startTime + gap * 610, "F"), new Beat(startTime + gap * 613, "L"),
					new Beat(startTime + gap * 616, "J"), new Beat(startTime + gap * 620, "S"),
					new Beat(startTime + gap * 622, "S"), new Beat(startTime + gap * 626, "K"),
					new Beat(startTime + gap * 629, "S"), new Beat(startTime + gap * 631, "S"),
					new Beat(startTime + gap * 634, "K"), new Beat(startTime + gap * 638, "D"),
					new Beat(startTime + gap * 641, "F"), new Beat(startTime + gap * 643, "J"),
					new Beat(startTime + gap * 646, "K"), new Beat(startTime + gap * 647, "Space"),
					new Beat(startTime + gap * 650, "S"), new Beat(startTime + gap * 652, "D"),
					new Beat(startTime + gap * 656, "F"), new Beat(startTime + gap * 660, "D"),
					new Beat(startTime + gap * 665, "F"), new Beat(startTime + gap * 671, "F"),
					new Beat(startTime + gap * 674, "F"), new Beat(startTime + gap * 677, "K"),
					new Beat(startTime + gap * 679, "F"), new Beat(startTime + gap * 682, "K"),
					new Beat(startTime + gap * 686, "D"), new Beat(startTime + gap * 689, "K"),
					new Beat(startTime + gap * 692, "F"), new Beat(startTime + gap * 696, "K"),
					new Beat(startTime + gap * 700, "F"), new Beat(startTime + gap * 703, "L"),
					new Beat(startTime + gap * 706, "J"), };
		} else if (titleName.equals("Silhouette") && difficulty.equals("Hard")) {
			int startTime = 22000 - Main.REACH_TIME;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime + gap * 1, "F"), new Beat(startTime + gap * 5, "K"),
					new Beat(startTime + gap * 7, "S"), new Beat(startTime + gap * 10, "K"),
					new Beat(startTime + gap * 11, "K"), new Beat(startTime + gap * 13, "D"),
					new Beat(startTime + gap * 16, "K"), new Beat(startTime + gap * 17, "K"),
					new Beat(startTime + gap * 18, "F"), new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 21, "K"), new Beat(startTime + gap * 22, "F"),
					new Beat(startTime + gap * 24, "F"), new Beat(startTime + gap * 26, "K"),
					new Beat(startTime + gap * 27, "K"), new Beat(startTime + gap * 30, "F"),
					new Beat(startTime + gap * 31, "K"), new Beat(startTime + gap * 32, "S"),
					new Beat(startTime + gap * 36, "D"), new Beat(startTime + gap * 37, "K"),
					new Beat(startTime + gap * 39, "K"), new Beat(startTime + gap * 42, "F"),
					new Beat(startTime + gap * 44, "K"), new Beat(startTime + gap * 46, "S"),
					new Beat(startTime + gap * 50, "F"), new Beat(startTime + gap * 52, "K"),
					new Beat(startTime + gap * 53, "L"), new Beat(startTime + gap * 56, "J"),
					new Beat(startTime + gap * 58, "K"), new Beat(startTime + gap * 60, "S"),
					new Beat(startTime + gap * 62, "S"), new Beat(startTime + gap * 64, "K"),
					new Beat(startTime + gap * 66, "K"), new Beat(startTime + gap * 69, "S"),
					new Beat(startTime + gap * 73, "K"), new Beat(startTime + gap * 75, "F"),
					new Beat(startTime + gap * 78, "K"), new Beat(startTime + gap * 80, "K"),
					new Beat(startTime + gap * 81, "D"), new Beat(startTime + gap * 83, "J"),
					new Beat(startTime + gap * 85, "K"), new Beat(startTime + gap * 86, "K"),
					new Beat(startTime + gap * 97, "Space"), new Beat(startTime + gap * 99, "K"),
					new Beat(startTime + gap * 100, "S"), new Beat(startTime + gap * 102, "D"),
					new Beat(startTime + gap * 104, "K"), new Beat(startTime + gap * 106, "F"),
					new Beat(startTime + gap * 110, "D"), new Beat(startTime + gap * 115, "K"),
					new Beat(startTime + gap * 120, "F"), new Beat(startTime + gap * 124, "F"),
					new Beat(startTime + gap * 126, "K"), new Beat(startTime + gap * 127, "Space"),
					new Beat(startTime + gap * 129, "F"), new Beat(startTime + gap * 130, "K"),
					new Beat(startTime + gap * 132, "K"), new Beat(startTime + gap * 136, "D"),
					new Beat(startTime + gap * 137, "K"), new Beat(startTime + gap * 139, "K"),
					new Beat(startTime + gap * 142, "F"), new Beat(startTime + gap * 144, "K"),
					new Beat(startTime + gap * 146, "K"), new Beat(startTime + gap * 150, "F"),
					new Beat(startTime + gap * 152, "K"), new Beat(startTime + gap * 153, "F"),
					new Beat(startTime + gap * 156, "J"), new Beat(startTime + gap * 158, "K"),
					new Beat(startTime + gap * 10, "K"), new Beat(startTime + gap * 160, "S"),
					new Beat(startTime + gap * 162, "S"), new Beat(startTime + gap * 164, "K"),
					new Beat(startTime + gap * 166, "K"), new Beat(startTime + gap * 169, "Space"),
					new Beat(startTime + gap * 170, "K"), new Beat(startTime + gap * 171, "S"),
					new Beat(startTime + gap * 174, "K"), new Beat(startTime + gap * 176, "K"),
					new Beat(startTime + gap * 178, "D"), new Beat(startTime + gap * 181, "F"),
					new Beat(startTime + gap * 182, "K"), new Beat(startTime + gap * 183, "J"),
					new Beat(startTime + gap * 186, "K"), new Beat(startTime + gap * 190, "K"),
					new Beat(startTime + gap * 194, "Space"), new Beat(startTime + gap * 198, "S"),
					new Beat(startTime + gap * 205, "K"), new Beat(startTime + gap * 212, "D"),
					new Beat(startTime + gap * 216, "F"), new Beat(startTime + gap * 219, "K"),
					new Beat(startTime + gap * 220, "F"), new Beat(startTime + gap * 224, "Space"),
					new Beat(startTime + gap * 225, "K"), new Beat(startTime + gap * 227, "K"),
					new Beat(startTime + gap * 229, "F"), new Beat(startTime + gap * 230, "K"),
					new Beat(startTime + gap * 232, "K"), new Beat(startTime + gap * 236, "D"),
					new Beat(startTime + gap * 237, "K"), new Beat(startTime + gap * 239, "K"),
					new Beat(startTime + gap * 242, "F"), new Beat(startTime + gap * 243, "K"),
					new Beat(startTime + gap * 246, "K"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 251, "K"), new Beat(startTime + gap * 253, "L"),
					new Beat(startTime + gap * 256, "J"), new Beat(startTime + gap * 257, "K"),
					new Beat(startTime + gap * 260, "S"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 263, "K"), new Beat(startTime + gap * 266, "K"),
					new Beat(startTime + gap * 269, "S"), new Beat(startTime + gap * 270, "K"),
					new Beat(startTime + gap * 271, "S"), new Beat(startTime + gap * 274, "K"),
					new Beat(startTime + gap * 275, "K"), new Beat(startTime + gap * 278, "D"),
					new Beat(startTime + gap * 281, "F"), new Beat(startTime + gap * 282, "K"),
					new Beat(startTime + gap * 283, "J"), new Beat(startTime + gap * 286, "K"),
					new Beat(startTime + gap * 287, "K"), new Beat(startTime + gap * 297, "Space"),
					new Beat(startTime + gap * 300, "S"), new Beat(startTime + gap * 301, "K"),
					new Beat(startTime + gap * 302, "D"), new Beat(startTime + gap * 306, "F"),
					new Beat(startTime + gap * 307, "K"), new Beat(startTime + gap * 310, "J"),
					new Beat(startTime + gap * 320, "S"), new Beat(startTime + gap * 321, "K"),
					new Beat(startTime + gap * 322, "L"), new Beat(startTime + gap * 324, "F"),
					new Beat(startTime + gap * 326, "K"), new Beat(startTime + gap * 327, "K"),
					new Beat(startTime + gap * 329, "F"), new Beat(startTime + gap * 330, "K"),
					new Beat(startTime + gap * 332, "K"), new Beat(startTime + gap * 336, "D"),
					new Beat(startTime + gap * 337, "K"), new Beat(startTime + gap * 339, "K"),
					new Beat(startTime + gap * 342, "F"), new Beat(startTime + gap * 343, "K"),
					new Beat(startTime + gap * 346, "K"), new Beat(startTime + gap * 350, "F"),
					new Beat(startTime + gap * 351, "K"), new Beat(startTime + gap * 353, "L"),
					new Beat(startTime + gap * 356, "J"), new Beat(startTime + gap * 357, "K"),
					new Beat(startTime + gap * 360, "S"), new Beat(startTime + gap * 362, "S"),
					new Beat(startTime + gap * 363, "K"), new Beat(startTime + gap * 366, "K"),
					new Beat(startTime + gap * 369, "L"), new Beat(startTime + gap * 370, "K"),
					new Beat(startTime + gap * 371, "S"), new Beat(startTime + gap * 374, "K"),
					new Beat(startTime + gap * 375, "K"), new Beat(startTime + gap * 378, "D"),
					new Beat(startTime + gap * 381, "F"), new Beat(startTime + gap * 382, "K"),
					new Beat(startTime + gap * 383, "J"), new Beat(startTime + gap * 384, "Space"),
					new Beat(startTime + gap * 385, "K"), new Beat(startTime + gap * 388, "S"),
					new Beat(startTime + gap * 392, "D"), new Beat(startTime + gap * 393, "K"),
					new Beat(startTime + gap * 396, "F"), new Beat(startTime + gap * 400, "S"),
					new Beat(startTime + gap * 401, "K"), new Beat(startTime + gap * 404, "F"),
					new Beat(startTime + gap * 407, "K"), new Beat(startTime + gap * 408, "K"),
					new Beat(startTime + gap * 410, "F"), new Beat(startTime + gap * 412, "K"),
					new Beat(startTime + gap * 413, "K"), new Beat(startTime + gap * 416, "D"),
					new Beat(startTime + gap * 419, "K"), new Beat(startTime + gap * 420, "K"),
					new Beat(startTime + gap * 422, "F"), new Beat(startTime + gap * 426, "J"),
					new Beat(startTime + gap * 427, "K"), new Beat(startTime + gap * 430, "F"),
					new Beat(startTime + gap * 433, "L"), new Beat(startTime + gap * 434, "K"),
					new Beat(startTime + gap * 436, "J"), new Beat(startTime + gap * 440, "S"),
					new Beat(startTime + gap * 441, "K"), new Beat(startTime + gap * 442, "F"),
					new Beat(startTime + gap * 446, "K"), new Beat(startTime + gap * 447, "K"),
					new Beat(startTime + gap * 449, "S"), new Beat(startTime + gap * 455, "F"),
					new Beat(startTime + gap * 456, "K"), new Beat(startTime + gap * 458, "K"),
					new Beat(startTime + gap * 459, "D"), new Beat(startTime + gap * 460, "K"),
					new Beat(startTime + gap * 463, "J"), new Beat(startTime + gap * 466, "K"),
					new Beat(startTime + gap * 467, "K"), new Beat(startTime + gap * 477, "Space"),
					new Beat(startTime + gap * 480, "S"), new Beat(startTime + gap * 482, "K"),
					new Beat(startTime + gap * 482, "D"), new Beat(startTime + gap * 486, "F"),
					new Beat(startTime + gap * 487, "K"), new Beat(startTime + gap * 490, "D"),
					new Beat(startTime + gap * 493, "F"), new Beat(startTime + gap * 494, "K"),
					new Beat(startTime + gap * 494, "S"), new Beat(startTime + gap * 497, "Space"),
					new Beat(startTime + gap * 498, "K"), new Beat(startTime + gap * 499, "F"),
					new Beat(startTime + gap * 502, "K"), new Beat(startTime + gap * 503, "K"),
					new Beat(startTime + gap * 506, "D"), new Beat(startTime + gap * 509, "L"),
					new Beat(startTime + gap * 510, "K"), new Beat(startTime + gap * 512, "F"),
					new Beat(startTime + gap * 516, "K"), new Beat(startTime + gap * 517, "K"),
					new Beat(startTime + gap * 520, "F"), new Beat(startTime + gap * 523, "D"),
					new Beat(startTime + gap * 524, "K"), new Beat(startTime + gap * 526, "J"),
					new Beat(startTime + gap * 530, "S"), new Beat(startTime + gap * 531, "K"),
					new Beat(startTime + gap * 532, "F"), new Beat(startTime + gap * 536, "K"),
					new Beat(startTime + gap * 537, "K"), new Beat(startTime + gap * 539, "Space"),
					new Beat(startTime + gap * 541, "S"), new Beat(startTime + gap * 542, "K"),
					new Beat(startTime + gap * 547, "K"), new Beat(startTime + gap * 548, "D"),
					new Beat(startTime + gap * 549, "K"), new Beat(startTime + gap * 551, "F"),
					new Beat(startTime + gap * 553, "J"), new Beat(startTime + gap * 554, "K"),
					new Beat(startTime + gap * 556, "K"), new Beat(startTime + gap * 564, "Space"),
					new Beat(startTime + gap * 565, "K"), new Beat(startTime + gap * 568, "S"),
					new Beat(startTime + gap * 572, "D"), new Beat(startTime + gap * 573, "K"),
					new Beat(startTime + gap * 576, "F"), new Beat(startTime + gap * 580, "F"),
					new Beat(startTime + gap * 581, "K"), new Beat(startTime + gap * 584, "Space"),
					new Beat(startTime + gap * 587, "K"), new Beat(startTime + gap * 588, "K"),
					new Beat(startTime + gap * 589, "F"), new Beat(startTime + gap * 592, "K"),
					new Beat(startTime + gap * 593, "K"), new Beat(startTime + gap * 596, "D"),
					new Beat(startTime + gap * 599, "K"), new Beat(startTime + gap * 600, "K"),
					new Beat(startTime + gap * 602, "F"), new Beat(startTime + gap * 606, "K"),
					new Beat(startTime + gap * 607, "K"), new Beat(startTime + gap * 610, "F"),
					new Beat(startTime + gap * 613, "L"), new Beat(startTime + gap * 614, "K"),
					new Beat(startTime + gap * 616, "J"), new Beat(startTime + gap * 620, "S"),
					new Beat(startTime + gap * 621, "K"), new Beat(startTime + gap * 622, "S"),
					new Beat(startTime + gap * 626, "K"), new Beat(startTime + gap * 627, "K"),
					new Beat(startTime + gap * 629, "S"), new Beat(startTime + gap * 631, "S"),
					new Beat(startTime + gap * 632, "K"), new Beat(startTime + gap * 634, "K"),
					new Beat(startTime + gap * 638, "D"), new Beat(startTime + gap * 639, "K"),
					new Beat(startTime + gap * 641, "F"), new Beat(startTime + gap * 643, "J"),
					new Beat(startTime + gap * 644, "K"), new Beat(startTime + gap * 646, "K"),
					new Beat(startTime + gap * 647, "Space"), new Beat(startTime + gap * 648, "K"),
					new Beat(startTime + gap * 650, "S"), new Beat(startTime + gap * 652, "D"),
					new Beat(startTime + gap * 653, "K"), new Beat(startTime + gap * 656, "F"),
					new Beat(startTime + gap * 660, "D"), new Beat(startTime + gap * 661, "K"),
					new Beat(startTime + gap * 665, "F"), new Beat(startTime + gap * 671, "F"),
					new Beat(startTime + gap * 672, "K"), new Beat(startTime + gap * 674, "F"),
					new Beat(startTime + gap * 677, "K"), new Beat(startTime + gap * 678, "K"),
					new Beat(startTime + gap * 679, "F"), new Beat(startTime + gap * 682, "K"),
					new Beat(startTime + gap * 683, "K"), new Beat(startTime + gap * 686, "D"),
					new Beat(startTime + gap * 689, "K"), new Beat(startTime + gap * 690, "K"),
					new Beat(startTime + gap * 692, "F"), new Beat(startTime + gap * 696, "K"),
					new Beat(startTime + gap * 697, "K"),

			};
		}
		int i = 0;
		gameMusic.start();
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.remainingTime()) {
				Note note = new Note(beats[i].getNoteName(), score, difficulty);
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}

		}
	}

	//method that gets Score and return it
	public Score getScore() {
		return score;
	}

	//method that materialize judgment effects when user types the key
	public void judgeEvent(String judge) {
		if (!judge.equals("None")) {
			effect1Image = new ImageIcon(Main.class.getResource("../images/effect1.png")).getImage();
		}
		if (judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();
		} else if (judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/late.png")).getImage();
		} else if (judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/good.png")).getImage();
		} else if (judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/great.png")).getImage();
		} else if (judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/perfect.png")).getImage();
		} else if (judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/early.png")).getImage();
		}
	}
}
