package game1;

//Class that catches the key events from user during the game

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		if(TuneOfHeart.game == null)return;
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			TuneOfHeart.game.pressSBtn();
			
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			TuneOfHeart.game.pressDBtn();
		}else if(e.getKeyCode() == KeyEvent.VK_F) {
			TuneOfHeart.game.pressFBtn();
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			TuneOfHeart.game.pressSpaceBar();
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			TuneOfHeart.game.pressJBtn();
		}else if(e.getKeyCode() == KeyEvent.VK_K) {
			TuneOfHeart.game.pressKBtn();
		}else if(e.getKeyCode() == KeyEvent.VK_L) {
			TuneOfHeart.game.pressLBtn();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(TuneOfHeart.game == null)return;
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			TuneOfHeart.game.releaseSBtn();
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			TuneOfHeart.game.releaseDBtn();
		}else if(e.getKeyCode() == KeyEvent.VK_F) {
			TuneOfHeart.game.releaseFBtn();
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			TuneOfHeart.game.releaseSpaceBar();
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			TuneOfHeart.game.releaseJBtn();
		}else if(e.getKeyCode() == KeyEvent.VK_K) {
			TuneOfHeart.game.releaseKBtn();
		}else if(e.getKeyCode() == KeyEvent.VK_L) {
			TuneOfHeart.game.releaseLBtn();
		}
	}
}
