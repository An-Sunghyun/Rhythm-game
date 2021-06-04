package game1;


//Class that saves the score when user play game
public class Score {
	
	private int score = 0;

	public String getScore() {
		String scoreString = Integer.toString(score);
		return scoreString;
	}

	public void setScore(int score) {
		this.score += score;
	}

}
