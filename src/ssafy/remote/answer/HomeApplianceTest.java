package ssafy.remote.answer;

public class HomeApplianceTest {
	public static void main(String[] args) {
		RemoteControl controller = new RemoteControl();
		Tv tv = new Tv(50);
		SettopBox sb = new SettopBox(100);
		
		// setMode �� ��� ������ ������ �� �ֵ��� �Ѵ�.
		controller.setMode(tv);
		controller.powerOn();
		controller.volumeUp();
		controller.volumeUp();
		controller.volumeUp();
		
		controller.setMode(sb);
		controller.powerOn();
		controller.volumeUp();
		controller.volumeUp();
		controller.volumeDown();
		controller.powerOff();
		
		System.out.println(tv);
		System.out.println(sb);
		
	}

}
