package ssafy.remote.afterFeedback;

public class SetTop extends Product{
	public SetTop(int volumn, int maxVolumn) {
		super(volumn, maxVolumn);
	}

	@Override
	void volumnUp() {
		if(getVolumn()+5 > getMaxVolumn())
			System.out.println("최대 볼륨보다 큽니다");
		else {
			setVolumn(getVolumn()+5);
			System.out.println("현재 볼륨은 : "+getVolumn());
		}
	}

	@Override
	void volumnDown() {
		if(getVolumn()-5 < Product.MIN_VOLUMN)
			System.out.println("최소 볼륨보다 작습니다");
		else {
			setVolumn(getVolumn()-5);
			System.out.println("현재 볼륨은 : "+getVolumn());
		}
	}
}
