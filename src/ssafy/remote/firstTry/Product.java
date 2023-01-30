package ssafy.remote.firstTry;

public abstract class Product {
	private boolean power;
	private int volumn;
	private int maxVolumn;
	private int minVolumn;
	private int value;	
	
	public Product(int volumn, int maxVolumn, int minVolumn, int value) {
		super();
		this.power = false;
		this.volumn = volumn;
		this.maxVolumn = maxVolumn;
		this.minVolumn = minVolumn;
		this.value = value;
	}
	
	public boolean isPower() {
		return power;
	}

	public int getValue() {
		return value;
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

	void volumnUp(int value) {
		if(volumn + value > maxVolumn)
			System.out.println("최대 볼륨보다 큽니다");
		else {
			volumn += value;
			System.out.println("현재 볼륨은 : "+volumn);
		}
	}
	
	void volumnDown(int value) {
		if(volumn - value < minVolumn)
			System.out.println("최소 볼륨보다 작습니다");
		else {
			volumn -= value;
			System.out.println("현재 볼륨은 : "+volumn);
		}		
	}
}
