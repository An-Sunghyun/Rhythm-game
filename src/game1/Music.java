package game1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

//class that saves every info related with music
public class Music extends Thread{

	private Player player;
	private boolean isRepeat;
	private File file;
	private FileInputStream finput;
	private BufferedInputStream bfinput;
	
	//Constructor
	public Music(String name, boolean isRepeat) {
		try {
			this.isRepeat = isRepeat;
			file = new File(Main.class.getResource("../music/"+name).toURI());
			finput = new FileInputStream(file);
			bfinput = new BufferedInputStream(finput);
			player = new Player(bfinput);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Method that counts remaining time of music
	public int remainingTime() { //getTime(원래 메소드명)
		if(player == null) {
			return 0;
		}
		return player.getPosition();
	}
	
	//Method that helps users to stop game whenever they want to
	public void close() {
		isRepeat = false;
		player.close();
		this.interrupt();
	}
	public void run() {
		try {
			do {
				player.play();
				finput = new FileInputStream(file);
				bfinput = new BufferedInputStream(finput);
				player = new Player(bfinput);
			}while(isRepeat);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
