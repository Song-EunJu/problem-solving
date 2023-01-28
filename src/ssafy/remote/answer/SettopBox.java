package ssafy.remote.answer;

public class SettopBox extends HomeAppliance {

	public SettopBox(int maxVolume) {
		super(maxVolume);
	}

	@Override
	public void volumeUp() {
		if(volume != MAX_VOLUME){
			volume += 5;
		}
		System.out.println("볼륨 up : "+this.toString());
	}

	@Override
	public void volumeDown() {
		if(volume != MIN_VOLUME){
			volume -= 5;
		}
		System.out.println("볼륨 down : "+this.toString());
	}

	@Override
	public String toString() {
		return "SettopBox [volume=" + volume + ", MAX_VOLUME=" + MAX_VOLUME
				+ ", powerOn=" + powerOn + "]";
	}


	
	
}
