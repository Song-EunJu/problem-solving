package ssafy.remote.answer;

public class Tv extends HomeAppliance {

	public Tv(int maxVolume) {
		super(maxVolume);
	}

	@Override
	public void volumeUp() {
		if(volume != MAX_VOLUME){
			volume ++;
		}
		System.out.println("볼륨 up : "+this.toString());		
	}

	@Override
	public void volumeDown() {
		if(volume != MIN_VOLUME){
			volume --;
		}
		System.out.println("볼륨 down : "+this.toString());		
	}

	@Override
	public String toString() {
		return "Tv [volume=" + volume + ", MAX_VOLUME=" + MAX_VOLUME
				+ ", powerOn=" + powerOn + "]";
	}


	
	
}
