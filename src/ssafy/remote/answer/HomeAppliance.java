package ssafy.remote.answer;

/**
 * 리모콘이 제어만 하는거고, 볼륨 조절, 전원 on off 하는 대상은 TV, 셋톱 박스임
 * 따라서 가전이 볼륨을 조절하고, 전원을 on off 하는 메소드를 가진 Controllable 을 구현하는 것임.
 * 이 코드를 사용하면 어떤 가전제품이든, Controllable 인터페이스를 받아서 구현하는 어떤 것도 제어 가능한 리모컨이 되는 것
 */
public abstract class HomeAppliance implements Controllable {

	// HomeAppliance 는 각각의 volumn을 가져야함
	public int volume;
	
	// 최대 볼륨은 세팅되면 바뀌면 안되기 때문에 final 로 선언
	// 또한 여기에 생성자로 초기화하는 이유가 디폴트값으로 초기화해버리면, 한번 초기값 설정이 된거라 다음부터 변경할 수 없음 
	public final int MAX_VOLUME;
	
	// min_volumn 은 최소 볼륨 0 으로 다 동일하니까 static
	public static final int MIN_VOLUME = 0;
	public boolean powerOn;
	
	public HomeAppliance(int maxVolume) {
		super();
		this.MAX_VOLUME = maxVolume; // final 객체상수, 생성자에서 초기화해야함 
	}

	@Override
	public void powerOn() {
		if(!powerOn){
			powerOn = true;
			System.out.println(this.getClass().getSimpleName()+"�쓽 �쟾�썝�씠 耳쒖죱�뒿�땲�떎.");
		}
	}

	@Override
	public void powerOff() {
		if(powerOn){
			powerOn = false;
			System.out.println(this.getClass().getSimpleName()+"�쓽 �쟾�썝�씠 爰쇱죱�뒿�땲�떎.");
		}
	}
}
