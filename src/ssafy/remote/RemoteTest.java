package ssafy.remote;

public class RemoteTest {
	public static void main(String[] args) {
		TV tv = new TV(0, 10);
		SetTop setTop = new SetTop(0, 20);
		
		RemoteController remote = new RemoteController(); // 리모콘 생성

		// 티비
		remote.setpMode(tv);
		remote.productOnOff();
		remote.volumnUp();
		remote.volumnUp();
		remote.volumnUp();
		remote.volumnDown();
		remote.volumnDown();
		remote.productOnOff();

		// 셋톱박스
		remote.setpMode(setTop);
		remote.productOnOff();
		remote.volumnUp();
		remote.volumnDown();
		remote.volumnDown();
		remote.volumnDown();
		remote.productOnOff();
	}
}
