package ssafy.remote.afterFeedback;

public class TV extends Product{
	public TV(int volumn, int maxVolumn) {
		super(volumn, maxVolumn);
	}

	@Override
	void volumnUp() {
		if(getVolumn()+1 > getMaxVolumn())
			System.out.println("최대 볼륨보다 큽니다");
		else {
			setVolumn(getVolumn()+1);
			System.out.println("현재 볼륨은 : "+getVolumn());
		}
	}

	@Override
	void volumnDown() {
		if(getVolumn()-1 < Product.MIN_VOLUMN)
			System.out.println("최소 볼륨보다 작습니다");
		else {
			setVolumn(getVolumn()-1);
			System.out.println("현재 볼륨은 : "+getVolumn());
		}
	}
}
