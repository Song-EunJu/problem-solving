public class RemoteController {
	void volumnUp(Product p) {
		p.volumnUp(p.getValue());
	}
	
	void volumnDown(Product p) {
		p.volumnDown(p.getValue());
	}
	
	void productOnOff(Product p) {
		if(p.isPower()) // 켜져있으면 끄고
			p.off();
		else // 꺼져있으면 켜라
			p.on();
	}
}
