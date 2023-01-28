package ssafy.remote.answer;

public class RemoteControl {
	/**
	 * ���� : has-a �����,  Ŭ���� ������ ���� ���迡 �ִ� Ŭ������ �ν��Ͻ� ���� ������ �ִ� ��)
	 * ���� ����� ������ �����, ��Ÿ�� �ð����� ���谡 ����� �� �ִ�
	 * �̷��� ������ ������ ������ Controllable �� �������̽��� �����Ͽ� �������� Ȱ���� �� �ֱ� �����̴�
	 * �� ������ ���忡���� ������ Ű�� ���� ��� ��ǰ�� �����ϱ� ���ؼ�, Home Appliance�� �ƴ϶� Controllable Ÿ���� �����ϵ��� �� ��
	 * �� Controllable �� ����ü�� �����ϰ� �ٲپ� ���� ��
	 * 
	 * �Ȱ��� �۾��� �ϰ� ������ ��� �ٲٸ鼭 ������ �޶����� ��. ��ü ��ü�� �����ϰ�!
	 * �� ������ ���忡���� ��Ʈ���ϴ� ����� �ٲٱ⸸ �ϸ� �� 
	 * �������� ����� Ƽ��� ����ڽ��� ������, �������̽��� ��Ű�� ������ ������ϵ��� �Ѵ�.
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
