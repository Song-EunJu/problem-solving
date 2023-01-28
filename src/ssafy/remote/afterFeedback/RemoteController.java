package ssafy.remote.afterFeedback;

public class RemoteController implements Controllable {
	private Product pMode; // has-a

	public void setpMode(Product pMode) {
		this.pMode = pMode;
	}

	public void volumnUp() {
		pMode.volumnUp();
	}
	
	public void volumnDown() {
		pMode.volumnDown();
	}

	public void productOnOff() {
		if(pMode.isPower())
			pMode.off();
		else
			pMode.on();
	}
}
