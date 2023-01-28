package ssafy.remote.answer;

public class RemoteControl {
	/**
	 * 위임 : has-a 관계로,  클래스 내에서 위임 관계에 있는 클래스의 인스턴스 값을 가지고 있는 것)
	 * 위임 관계는 동적인 관계로, 런타임 시간동안 관계가 변경될 수 있다
	 * 이러한 동작이 가능한 이유는 Controllable 을 인터페이스로 구현하여 다형성을 활용할 수 있기 때문이다
	 * → 리모콘 입장에서는 전원을 키고 끄는 모든 제품을 제어하기 위해서, Home Appliance가 아니라 Controllable 타입을 제어하도록 한 것
	 * → Controllable 의 구현체만 적절하게 바꾸어 끼면 됨
	 *
	 * 똑같은 작업을 하고 있지만 대상만 바꾸면서 동작을 달라지게 함. 객체 교체를 용이하게!
	 * → 리모콘 입장에서는 컨트롤하는 대상을 바꾸기만 하면 됨
	 * 리모컨은 대상이 티비든 셋톱박스든 누구든, 인터페이스만 지키고 있으면 제어가능하도록 한다.
	 */
	Controllable target;

	public void setMode(Controllable target){
		this.target = target;
	}
	public void powerOn(){
		target.powerOn();
	}
	public void powerOff(){
		target.powerOff();
	}
	public void volumeUp(){
		target.volumeUp();
	}
	public void volumeDown(){
		target.volumeDown();
	}
}
