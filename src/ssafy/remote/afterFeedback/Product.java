package ssafy.remote.afterFeedback;

public abstract class Product {
	private boolean power;
	private int volumn;
	private int maxVolumn;
	protected static final int MIN_VOLUMN = 0;

	public Product(int volumn, int maxVolumn) {
		super();
		this.power = false;
		this.volumn = volumn;
		this.maxVolumn = maxVolumn;
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}

	public int getMaxVolumn() {
		return maxVolumn;
	}

	public boolean isPower() {
		return power;
	}

	// 전원 on/off 공통 기능
	void on() {
		power = true;
		System.out.println("전원 ON");
	}	
	
	void off() {
		power = false;
		System.out.println("전원 OFF");
	}

	abstract void volumnUp();
	abstract void volumnDown();
}
