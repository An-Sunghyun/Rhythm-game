package game1;

//Class that manages all the information about track(music)

public class Track {
	private String titleImage; // Main image of music
	private String startImage; // Start image of music
	private String playImage; // Background image of playing music
	private String startMusic; // Music that plays in the selection frame
	private String gameMusic; // Actual Music when user plays game
	private String titleName; // Name of music
	private int playtime; // Time of music

	public Track(String titleImage, String startImage, String playImage, String startMusic, String gameMusic,
			String titleName, int playtime) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.playImage = playImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
		this.playtime = playtime;
	}

	
	// getter, setter
	public int getPlaytime() {
		return playtime;
	}

	public void setPlaytime(int playtime) {
		this.playtime = playtime;
	}
	
	public String getTitleImage() {
		return titleImage;
	}

	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}

	public String getStartImage() {
		return startImage;
	}

	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}

	public String getPlayImage() {
		return playImage;
	}

	public void setPlayImage(String playImage) {
		this.playImage = playImage;
	}

	public String getStartMusic() {
		return startMusic;
	}

	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}

	public String getGameMusic() {
		return gameMusic;
	}

	public void setGameMusic(String musicTitle) {
		this.gameMusic = gameMusic;
	}

	public String gettitleName() {
		return titleName;
	}

	public void settitleName(String titleName) {
		this.titleName = titleName;
	}

}
