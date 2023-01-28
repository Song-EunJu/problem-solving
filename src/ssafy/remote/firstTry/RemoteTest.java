public class RemoteTest {
	public static void main(String[] args) {
		Product[] p = {
				new TV(0, 10, 1, 5), 
				new SetTop(0, 20, 1, 1)
		};
		
		RemoteController remote = new RemoteController(); // 리모콘 생성
		
		for(int i=0;i<p.length;i++) {
			Product product = p[i];
			remote.productOnOff(product); // 리모콘으로 상품 전원 끄기
		
			for(int j=0;j<4;j++) // 볼륨 업
				remote.volumnUp(product);
			
			for(int j=0;j<3;j++)  // 볼륨 다운
				remote.volumnDown(product);
			
			remote.productOnOff(product); // 리모콘으로 상품 전원 끄기
			System.out.println("============================");
		}		
	}
}
